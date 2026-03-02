package com.capgemini.basics_spring_mvc_boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.basics_spring_mvc_boot.model.Employee;
import com.capgemini.basics_spring_mvc_boot.repository.EmployeeJpaRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeJpaRepository jpa;

	public EmployeeService(EmployeeJpaRepository jpa) {
		this.jpa = jpa;
	}

	public ModelAndView createEmployee(Employee e) {

		Optional<Employee> emp = jpa.findById(e.getEmail());

		ModelAndView m = new ModelAndView();

		if (emp.isEmpty()) {
			jpa.save(e);
			m.addObject("name", e.getName());
			m.setViewName("success");
			return m;
		} else {
			m.addObject("email", e.getEmail());
			m.setViewName("exist");
			return m;
		}

	}

	public Employee findByEmailAndPassword(String email, String password) {
		return jpa.findByEmailAndPassword(email, password);
	}

	public ModelAndView getAdminPage() {
		ModelAndView m = new ModelAndView();

		List<Employee> emps = jpa.findAll();

		m.addObject("list_of_employees", emps);
		m.setViewName("admin_page");
		return m;
	}

	public ModelAndView getUserPage(String name) {
		ModelAndView m = new ModelAndView();

		m.addObject("name", name);
		m.setViewName("user_page");
		return m;
	}

	public ModelAndView getLoginPage() {
		ModelAndView m = new ModelAndView();

		m.setViewName("login");
		return m;
	}

	public void deleteByEmail(String email) {
		Optional<Employee> emp = jpa.findById(email);
		if (emp.isPresent()) {
			jpa.deleteById(email);
		}
	}

	public void updateByEmail(Employee emp) {
		Optional<Employee> emp1 = jpa.findById(emp.getEmail());
		if (emp1.isPresent()) {
			jpa.save(emp);
		}
	}

	public ModelAndView getUpdatePage(String email) {
		ModelAndView m = new ModelAndView();
		Optional<Employee> emp = jpa.findById(email);
		if (emp.isPresent()) {
			m.addObject("emp", emp.get());
		}
		m.setViewName("update_details");
		return m;
	}

}
