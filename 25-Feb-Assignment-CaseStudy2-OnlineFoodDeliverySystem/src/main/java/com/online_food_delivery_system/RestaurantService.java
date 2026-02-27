package com.online_food_delivery_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantService {

	private DeliveryService deliveryService;

	@Autowired
	public void setDeliveryService(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	public void prepareOrder(String orderId) {
		System.out.println("Restaurant preparing order: " + orderId);
		deliveryService.assignDelivery(orderId);
	}

}
