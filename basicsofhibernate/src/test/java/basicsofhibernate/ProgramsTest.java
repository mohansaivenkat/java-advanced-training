package basicsofhibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.programs.Programs;

public class ProgramsTest {

	
	@ParameterizedTest
	@ValueSource(strings = {"tenet","naman","abba"})
	public void isPalindromeTest(String str) {
		assertTrue(Programs.isPalindrome(str));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,2,3",
		"4,5,9",
		"23,42,65"
	})
	public void addTest(Integer a , Integer b , Integer expected) {
		assertEquals(expected, Programs.add(a, b));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/input.csv",numLinesToSkip = 1)
	public void addEvenOrOddTest(String num,String exp) {
		assertEquals(exp, Programs.isEvenOrOdd(Integer.parseInt(num)));
	}
	
	
	
}
