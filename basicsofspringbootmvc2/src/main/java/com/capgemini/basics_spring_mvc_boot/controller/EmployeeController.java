package com.capgemini.basics_spring_mvc_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.basics_spring_mvc_boot.model.Employee;
import com.capgemini.basics_spring_mvc_boot.model.Role;
import com.capgemini.basics_spring_mvc_boot.service.EmployeeService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empserv;

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/create-account")
	public ModelAndView register(@ModelAttribute Employee emp) {

		System.out.println("Name: " + emp.getName());
		System.out.println("Email: " + emp.getEmail());
		System.out.println("Salary: " + emp.getSalary());
		System.out.println("Role: " + emp.getRole());

		return empserv.createEmployee(emp);
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/logincheck")
	public ModelAndView logincheck(HttpServletRequest response) {
		Employee user2 = empserv.findByEmailAndPassword(response.getParameter("email"),
				response.getParameter("password"));

		if (user2 != null) {
			if (user2.getRole().equals(Role.Admin)) {

				return empserv.getAdminPage();
			} else {
				return empserv.getUserPage(response.getParameter("name"));
			}

		} else {
			return empserv.getLoginPage();
		}
	}

	@GetMapping("/delete-emp")
	public ModelAndView deleteRecord(@RequestParam String email) {
		empserv.deleteByEmail(email);
		return empserv.getAdminPage();
	}

	@GetMapping("/update")
	public ModelAndView updateRecord(@RequestParam String email) {
		return empserv.getUpdatePage(email);
	}

	@PostMapping("/update-emp")
	public ModelAndView updateRecord(@ModelAttribute Employee emp) {
		empserv.updateByEmail(emp);
		return empserv.getAdminPage();
	}

}
