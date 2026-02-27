package com.online_food_delivery_system;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("singleton")
public class DeliveryService {

	public void assignDelivery(String orderId) {
		System.out.println("Delivery assigned for order: " + orderId);
	}

	@PostConstruct
	public void init() {
		System.out.println("Delivery Service Ready");
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("Delivery Service Closed");
	}

}
