package com.prac;

public class Calculator {
	public static int add(int a , int b) {
		return a+b;
	}
	
	public static String reverse(String s) {
		String rev ="";
		
		for(int i=s.length()-1;i>=0;i--) {
			rev+=s.charAt(i);
		}
		
		return rev;
	}
	
	public static Integer div(int a , int b) {
		return a/b;
	}
}
