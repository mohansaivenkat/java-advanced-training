package com.smart_payment_processing_system;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements PaymentService {

	private TransactionLogger logger;

	public UpiPayment(TransactionLogger logger) {
		this.logger = logger;
		System.out.println("UpiPayment bean created");
	}

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing UPI payment of Rs." + amount);
		logger.log("UPI payment of Rs." + amount + " completed");
	}

}
