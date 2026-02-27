package com.smart_payment_processing_system;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class TransactionLogger {

	public void log(String message) {
		System.out.println("Transaction Log: " + message);
	}

	@PostConstruct
	public void init() {
		System.out.println("Logger initialized");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Logger destroyed");
	}

}
