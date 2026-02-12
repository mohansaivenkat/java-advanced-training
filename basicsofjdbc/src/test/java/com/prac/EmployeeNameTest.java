package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmployeeNameTest {
	
	@Test
	public void addEmployeeNameTest() {
		
		Employee emp1 = new Employee(101,"Mohan",21,"CSE");
		
		assertEquals(true, emp1.isValidName(emp1.getName()));
		assertTrue(emp1.isValidAge(emp1.getAge()));
	}
	
	@Test
	public void addEmployeeNameTest2() {
		
		boolean b = Employee.isValidName("Mohan2*@");
		assertEquals(false, b);
		
	}
	
	@Test
	public void addEmployeeNameTest3() {
		Employee emp2 = new Employee(102,"Moh2",12,"CSE");
		
		//assertTrue(emp2.isValidName(emp2.getName()));
		// test fails becoz asserTrue fails on false boolean value
		// so we will use assertFalse to pass the testcase
		
		assertFalse(emp2.isValidName(emp2.getName()));
		assertFalse(emp2.isValidAge(emp2.getAge()));
		
		
	}
	
	@Test
	public void addEmployeeNameTest4() {
		Employee emp2 = new Employee(102,"Moh_",12,"CSE");
		
		//assertTrue(emp2.isValidName(emp2.getName()));
		// test fails becoz asserTrue fails on false boolean value
		// so we will use assertFalse to pass the testcase
		
		assertFalse(emp2.isValidName(emp2.getName()));
		assertFalse(emp2.isValidAge(emp2.getAge()));
		
		
	}

}
