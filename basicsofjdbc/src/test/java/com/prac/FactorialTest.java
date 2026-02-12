package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FactorialTest {

	@Test
	public void addFactorialTest() {
		Integer i = Factorial.factorial(5);
		
		assertEquals(120,i);
	}
	
}
