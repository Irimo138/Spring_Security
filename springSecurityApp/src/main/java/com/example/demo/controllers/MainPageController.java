package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.Product;
import com.example.demo.services.JpaUserDetailsService;
import com.example.demo.services.ProductService;

@Controller
public class MainPageController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	ProductService productService;
	JpaUserDetailsService jpaUserDetailsService;
	
	@Autowired
	public void setJpaUserDetailsService(JpaUserDetailsService jpaUserDetailsService) {
		this.jpaUserDetailsService = jpaUserDetailsService;
	}
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/main")
	public ModelAndView main() {
		ModelAndView m = new ModelAndView();
		m.addObject("products",productService.obtenerTodos());
		m.setViewName("index");
		return m;
	}
	@GetMapping("/adduser")
	public String adduser() {
		String username = "john";
		String password = bCryptPasswordEncoder.encode("1234");
		String role = "ADMIN";
		jpaUserDetailsService.addUser(username, password, role);
		String username2 = "jane";
		String password2 = bCryptPasswordEncoder.encode("1234");
		String role2 = "MANAGER";
		jpaUserDetailsService.addUser(username2, password2, role2);
		return "redirect:/login";
	}
	@PostMapping("/anadirproductos")
	public String anadirProductos() {
		Product p1 = new Product("Pelota", 21, "Euro");
		productService.crearProducto(p1);
		return  "redirect:/main";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
