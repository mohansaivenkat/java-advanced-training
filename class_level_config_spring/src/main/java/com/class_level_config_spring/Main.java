package com.class_level_config_spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
		
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		
		Employee e = ioc.getBean(Employee.class);
		
		System.out.println(e);
		
		Person p = ioc.getBean(Person.class);
		
	
		System.out.println(p.getMobile());
		
		System.out.println(ioc.getBean(Mobile.class));
		
		System.out.println(p.getScan());
		
		System.out.println(ioc.getBean(List.class));
		
		Map<String, Integer> mp = ioc.getBean("getMap",Map.class);
		
		System.out.println(mp);
		
	}

}
