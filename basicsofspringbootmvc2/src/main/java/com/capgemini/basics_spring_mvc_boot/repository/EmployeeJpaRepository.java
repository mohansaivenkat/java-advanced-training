package com.capgemini.basics_spring_mvc_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.basics_spring_mvc_boot.model.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, String> {

	public Employee findByEmailAndPassword(String email, String password);

}
