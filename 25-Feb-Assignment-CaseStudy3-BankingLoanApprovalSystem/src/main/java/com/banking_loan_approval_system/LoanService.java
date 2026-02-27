package com.banking_loan_approval_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoanService {

	private LoanValidator loanValidator;
	private AuditService auditService;

	public LoanService(@Qualifier("incomeValidator") LoanValidator loanValidator) {
		this.loanValidator = loanValidator;
	}

	@Autowired
	public void setAuditService(AuditService auditService) {
		this.auditService = auditService;
	}

	public void applyForLoan(double amount) {
		System.out.println("Applying for loan of Rs." + amount);
		loanValidator.validateLoan(amount);
		auditService.logAudit("Loan application for Rs." + amount + " processed");
	}

}
