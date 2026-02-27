package com.class_level_config_spring.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.class_level_config_spring.DemoConfiguration;

@Component
public class User {
	
	@Autowired
	@Qualifier("creditCard")
	private Payment payment; //null without autowired
	
	public void display() {
		payment.send();
	}
	
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		
		User user = ioc.getBean(User.class);
		
		user.display();
	}

}
