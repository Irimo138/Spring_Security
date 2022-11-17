package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.beans.SecurityUser;
import com.example.demo.beans.User;
import com.example.demo.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findUserByUsername(username).get();
		return new SecurityUser(u);
	}
	
	public void addUser(String username, String password, String role) {
		userRepository.save(new User(username, password, null, role));
	}
}
