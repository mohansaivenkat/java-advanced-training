package com.basicsofspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	
	public static void main(String[] args) {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
		
		Person p = ioc.getBean("person",Person.class);
		
		p.message();
		
		Employee e = (Employee) ioc.getBean("employee");
		
		
		System.out.println(e);
		
		
	}
}
