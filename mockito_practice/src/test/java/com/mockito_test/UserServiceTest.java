package com.mockito_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.Calculator;
import com.mockito.CalculatorService;
import com.mockito.UserService;
import com.mockito.UsersDao;
import com.mockito.Users;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	UsersDao userdao;

	@InjectMocks
	UserService userService;

	@Test
	public void testGetTypeOfCustomer() {
		Users u = new Users();
		u.setBalance(30000); // 30000 -> "New User"
		
		when(userdao.findUserById(1)).thenReturn(u);
		
		String actualRes = userService.typeOfUser(1);
		assertEquals("New User", actualRes);
	}
	
	@Test
	public void testDoubleAddition() {
		
		//creating fake object
		Calculator calmock = mock(Calculator.class);
		
		//what mock object should return
		when(calmock.addition(5, 5)).thenReturn(20);
		
		//inject the mock reference
		CalculatorService service = new CalculatorService(calmock);
		
		// Expected result is 2 * 20 = 40
		Integer res = service.doubleAddition(5, 5);
		assertEquals(40, res);
				
	}

}
