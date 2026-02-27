package com.springboot.basicsofspringboot;

public class Engine {

	
	private String fuelType;
	private int cc;
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	@Override
	public String toString() {
		return "Engine [fuelType=" + fuelType + ", cc=" + cc + "]";
	}
	
	
}
