package com.smart_payment_processing_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {

	private PaymentService paymentService;

	@Autowired
	private TransactionLogger transactionLogger;

	public PaymentProcessor(@Qualifier("upiPayment") PaymentService paymentService) {
		this.paymentService = paymentService;
		System.out.println("PaymentProcessor created with: " + paymentService.getClass().getSimpleName());
	}

	public void makePayment(double amount) {
		paymentService.processPayment(amount);
		transactionLogger.log("Payment processed via PaymentProcessor");
	}

}
