package com.springboot.basicsofspringboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String brand;
	private String model;
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String name) {
		this.brand = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	public Car() {
		super();
	}
	
	@Override
	public String toString() {
		return "Car [name=" + brand + ", model=" + model + ", engine=" + "]";
	}
	
	
	

}
