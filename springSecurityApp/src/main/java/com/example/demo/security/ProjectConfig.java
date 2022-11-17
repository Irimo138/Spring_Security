package com.example.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.example.demo.services.AuthenticationProviderService;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationProviderService authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors(c -> {
			CorsConfigurationSource source = request -> {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowedOrigins(
			List.of("http://localhost:8080"));
			config.setAllowedMethods(
			List.of("GET", "POST", "PUT", "DELETE"));
			return config;
			};
			c.configurationSource(source);
		});
		http.csrf().disable();
		http.authorizeRequests().anyRequest().permitAll();
	}
}
