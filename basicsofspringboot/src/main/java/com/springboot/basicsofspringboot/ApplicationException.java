package com.springboot.basicsofspringboot;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationException {
	
	@ExceptionHandler(CarDataDoesNotExistException.class)
	public String handleException() {
		return "Exception Handle Method - Data does not exist";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException2() {
		return "Error loading this page or this page doesnt exist";
	}
	

}
