package com.banking_loan_approval_system;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class AuditService {

	public void logAudit(String message) {
		System.out.println("Audit Log: " + message);
	}

	@PostConstruct
	public void init() {
		System.out.println("AuditService initialized");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("AuditService destroyed");
	}

}
