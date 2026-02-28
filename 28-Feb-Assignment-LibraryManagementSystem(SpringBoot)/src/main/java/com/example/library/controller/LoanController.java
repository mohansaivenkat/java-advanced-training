package com.example.library.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Loan;
import com.example.library.service.LoanService;

@RestController
@RequestMapping("/api/v1")
public class LoanController {

	@Autowired
	private LoanService loanService;

	@PostMapping("/loans/issue")
	public ResponseEntity<Loan> issueBook(@RequestParam Long memberId,
			@RequestParam Long bookId,
			@RequestParam String dueDate) {
		LocalDate due = LocalDate.parse(dueDate);
		return ResponseEntity.ok(loanService.issueBook(memberId, bookId, due));
	}

	@PutMapping("/loans/{loanId}/return")
	public ResponseEntity<Loan> returnBook(@PathVariable Long loanId) {
		return ResponseEntity.ok(loanService.returnBook(loanId));
	}

	@GetMapping("/loans/{loanId}")
	public ResponseEntity<Loan> getLoanById(@PathVariable Long loanId) {
		return ResponseEntity.ok(loanService.getLoanById(loanId));
	}

	@GetMapping("/loans")
	public ResponseEntity<List<Loan>> getAllLoans() {
		return ResponseEntity.ok(loanService.getAllLoans());
	}

	@GetMapping("/members/{memberId}/loans")
	public ResponseEntity<List<Loan>> getLoansByMember(@PathVariable Long memberId) {
		return ResponseEntity.ok(loanService.getLoansByMember(memberId));
	}

}
