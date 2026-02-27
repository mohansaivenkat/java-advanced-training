package com.class_level_config_spring.prac;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CreditCard implements Payment{
	@Override
	public void send() {
		System.out.println("Credit Card payment");
	}
}
