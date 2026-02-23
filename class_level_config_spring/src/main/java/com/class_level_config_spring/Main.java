package com.class_level_config_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		
		Employee e = ioc.getBean(Employee.class);
		
		System.out.println(e);
		
		Person p = ioc.getBean(Person.class);
		
	
		System.out.println(p.getMobile());
		
		System.out.println(ioc.getBean(Mobile.class));
		
		System.out.println(p.getScan());
		
	}

}
