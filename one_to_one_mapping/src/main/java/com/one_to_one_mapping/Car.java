package com.one_to_one_mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
	
	@Id
	private Integer id;
	private String brand;
	private String model;
	private Double price;
	private String modelYear;
	
	@OneToOne
	private Engine engine;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	
	public Car(int id, String brand, String model, double price, String modelYear) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.modelYear = modelYear;
	}
	
	
	
}