package com.prac;

public class Factorial {
	
	public static Integer factorial(int num) {
		if(num==0) {
			return 1;
		}
		
		return num*factorial(num-1);
	}

}
