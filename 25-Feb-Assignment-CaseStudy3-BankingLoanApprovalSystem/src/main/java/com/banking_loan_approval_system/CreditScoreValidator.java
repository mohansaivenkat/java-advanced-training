package com.banking_loan_approval_system;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditScoreValidator implements LoanValidator {

	@Override
	public void validateLoan(double amount) {
		System.out.println("Validating loan of Rs." + amount + " using Credit Score");
		if (amount <= 500000) {
			System.out.println("Loan APPROVED by Credit Score Validator");
		} else {
			System.out.println("Loan NEEDS REVIEW by Credit Score Validator");
		}
	}

}
