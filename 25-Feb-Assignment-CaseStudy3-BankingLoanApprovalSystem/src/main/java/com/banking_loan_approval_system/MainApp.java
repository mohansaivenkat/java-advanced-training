package com.banking_loan_approval_system;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BankAppConfig.class);

		System.out.println("--- Applying for Loan ---");
		LoanService loanService = context.getBean(LoanService.class);
		loanService.applyForLoan(250000);

		System.out.println("\n--- Testing Default (Primary) Validator ---");
		LoanValidator defaultValidator = context.getBean(LoanValidator.class);
		defaultValidator.validateLoan(600000);

		System.out.println("\n--- Prototype scope test - getting IncomeValidator twice ---");
		LoanValidator v1 = context.getBean(IncomeValidator.class);
		LoanValidator v2 = context.getBean(IncomeValidator.class);
		System.out.println("v1 == v2 ? " + (v1 == v2));

		System.out.println("\n--- Closing Context ---");
		context.close();

	}

}
