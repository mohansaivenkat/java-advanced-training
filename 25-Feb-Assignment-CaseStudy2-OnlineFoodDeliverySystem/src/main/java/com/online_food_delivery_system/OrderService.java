package com.online_food_delivery_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

	private NotificationService notificationService;

	@Autowired
	private RestaurantService restaurantService;

	public OrderService(@Qualifier("smsNotification") NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public void placeOrder(String orderId) {
		System.out.println("Order placed: " + orderId);
		restaurantService.prepareOrder(orderId);
		notificationService.sendNotification("Order " + orderId + " has been placed");
	}

}
