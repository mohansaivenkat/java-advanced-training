package com.smart_payment_processing_system;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println("--- Getting PaymentProcessor ---");
		PaymentProcessor processor = context.getBean(PaymentProcessor.class);
		processor.makePayment(1500.00);

		System.out.println("\n--- Getting CreditCardPayment (Lazy - created now) ---");
		PaymentService creditCard = context.getBean(CreditCardPayment.class);
		creditCard.processPayment(2500.00);

		System.out.println("\n--- Prototype scope test - getting UpiPayment twice ---");
		PaymentService upi1 = context.getBean(UpiPayment.class);
		PaymentService upi2 = context.getBean(UpiPayment.class);
		System.out.println("upi1 == upi2 ? " + (upi1 == upi2));

		System.out.println("\n--- Closing Context ---");
		context.close();

	}

}
