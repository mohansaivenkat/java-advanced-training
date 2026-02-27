package com.banking_loan_approval_system;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IncomeValidator implements LoanValidator {

	public IncomeValidator() {
		System.out.println("IncomeValidator bean created");
	}

	@Override
	public void validateLoan(double amount) {
		System.out.println("Validating loan of Rs." + amount + " using Income Verification");
		if (amount <= 300000) {
			System.out.println("Loan APPROVED by Income Validator");
		} else {
			System.out.println("Loan NEEDS REVIEW by Income Validator");
		}
	}

}
