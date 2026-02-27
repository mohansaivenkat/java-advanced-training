package com.online_food_delivery_system;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FoodAppConfig.class);

		System.out.println("--- Placing an Order ---");
		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder("ORD-101");

		System.out.println("\n--- Testing Default (Primary) NotificationService ---");
		NotificationService defaultNotification = context.getBean(NotificationService.class);
		defaultNotification.sendNotification("This uses the default (Email)");

		System.out.println("\n--- Testing Lazy SmsNotification ---");
		SmsNotification sms = context.getBean(SmsNotification.class);
		sms.sendNotification("Lazy SMS test");

		System.out.println("\n--- Closing Context ---");
		context.close();

	}

}
