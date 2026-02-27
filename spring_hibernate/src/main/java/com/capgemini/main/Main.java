package com.capgemini.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.ProjectConfiguration;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.Employee;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		
		Employee e1= ioc.getBean(Employee.class);
		
		Employee e2 = ioc.getBean(Employee.class);
		
		
		e1.setName("Mohan");
		e1.setId(101);
		e1.setSalary(30000d);
		
		e2.setName("Rohit");
		e2.setId(102);
		e2.setSalary(20000d);
		
		
		
		System.out.println(e1);
		System.out.println(e2);
		
		System.out.println(e1 == e2);
		
		EmployeeDao dao = ioc.getBean(EmployeeDao.class);
		
		dao.insert(e1);
		dao.insert(e2);
		
		
		 
       AnnotationConfigApplicationContext ac = (AnnotationConfigApplicationContext) ioc;
       ac.close();
		
		
		
		
		
		
	}

}
