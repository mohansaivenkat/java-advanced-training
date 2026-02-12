package com.prac;

public class Palindrome {

	public static boolean checkPalindrome(String s) {
		StringBuilder temp = new StringBuilder(s);
		temp.reverse();
		
		if(s.equals(temp.toString())) {
			return true;
		}
		else {
			return false;
		}
	}

}
