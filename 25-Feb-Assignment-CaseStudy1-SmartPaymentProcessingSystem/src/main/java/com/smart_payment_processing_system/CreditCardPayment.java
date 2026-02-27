package com.smart_payment_processing_system;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CreditCardPayment implements PaymentService {

	private TransactionLogger logger;

	public CreditCardPayment(TransactionLogger logger) {
		this.logger = logger;
		System.out.println("CreditCardPayment bean created");
	}

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing Credit Card payment of Rs." + amount);
		logger.log("Credit Card payment of Rs." + amount + " completed");
	}

}
