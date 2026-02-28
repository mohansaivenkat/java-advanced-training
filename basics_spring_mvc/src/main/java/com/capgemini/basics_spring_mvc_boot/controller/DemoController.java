package com.capgemini.basics_spring_mvc_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.basics_spring_mvc_boot.model.Users;
import com.capgemini.basics_spring_mvc_boot.repository.UsersJpaRepository;

@Controller
public class DemoController {
	
	@Autowired
	UsersJpaRepository userjpa;
	
	@GetMapping("/hello")
	public String getHi() {
		return "welcome";
	}

	@GetMapping("/register")
	public String createAccount() {
		return "register";
	}
	
//	@PostMapping("/create-account")
//	public String register(HttpServletRequest request){
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		
//		System.out.println("Name: " + name);
//		System.out.println("Email: " + email);
//		System.out.println("Password: " + password);
//		
//		return "success";
//	}
	
	@PostMapping("/create-account")
	public String register(@ModelAttribute Users user){
		
		userjpa.save(user);
		
		System.out.println("Name: " + user.getName());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Contact: " + user.getContact());
		
		return "success";
	}
	
	

}
