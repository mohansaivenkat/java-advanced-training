package com.mockito;

public class CalculatorService {

	
	Calculator cal;
	
	public CalculatorService(Calculator cal){
		this.cal = cal;
	}
	
	public Integer doubleAddition(Integer a , Integer b) {
		return 2 * cal.addition(a, b);
	}
}
