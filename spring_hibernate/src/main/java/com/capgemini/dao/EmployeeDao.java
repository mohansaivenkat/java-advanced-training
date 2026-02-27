package com.capgemini.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.Employee;
import com.capgemini.main.JPAUtil;


@Repository
public class EmployeeDao {
	
	@Autowired
	JPAUtil jpa;
	
	public void insert(Employee e) {
		jpa.getEm().getTransaction().begin();
		
		Employee e1 = jpa.getEm().find(Employee.class, e.getId());
		
		if(e1 == null) {
			jpa.getEm().persist(e);
		}
		else {
			System.out.println("Data with Id: "+e.getId()+" already exists");
		}
		
		jpa.getEm().getTransaction().commit();
	}
	
	public Employee findById(Integer id) {
		return jpa.getEm().find(Employee.class, id);
	}
	
	public void UpdateById(String newName , Integer id) {
		
		jpa.getEm().getTransaction().begin();
		
		Employee e1 = jpa.getEm().find(Employee.class, id);
		
		if(e1!=null) {
			e1.setName(newName);
			jpa.getEm().merge(e1);
		}
		else {
			System.out.println("Employee with Id: "+id+" not found");
		}
		
		
		jpa.getEm().getTransaction().commit();
	}
	
	public void deleteById(Integer id) {
		jpa.getEm().getTransaction().begin();
		
		Employee e1 = jpa.getEm().find(Employee.class, id);
		
		if(e1 != null) {
			jpa.getEm().remove(e1);
		}else {
			System.out.println("Employee with Id: "+id+" not found");
		}
		
		jpa.getEm().getTransaction().commit();
	}

}
