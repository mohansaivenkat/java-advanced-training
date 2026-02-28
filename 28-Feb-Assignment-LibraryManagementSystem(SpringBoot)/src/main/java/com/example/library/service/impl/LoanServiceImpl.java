package com.example.library.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dao.BookRepository;
import com.example.library.dao.LoanRepository;
import com.example.library.dao.MemberRepository;
import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.Member;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Loan issueBook(Long memberId, Long bookId, LocalDate dueDate) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new ResourceNotFoundException("membar not found with id " + memberId));
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("bok not found with id " + bookId));

		if (book.getCopiesAvailable() <= 0) {
			throw new RuntimeException("no coipes availble for this book");
		}

		Loan loan = new Loan();
		loan.setMember(member);
		loan.setBook(book);
		loan.setIssueDate(LocalDate.now());
		loan.setDueDate(dueDate);
		loan.setLoanStatus("ISSUED");

		book.setCopiesAvailable(book.getCopiesAvailable() - 1);
		bookRepository.save(book);

		return loanRepository.save(loan);
	}

	@Override
	public Loan returnBook(Long loanId) {
		Loan loan = loanRepository.findById(loanId)
				.orElseThrow(() -> new ResourceNotFoundException("laon not found with id " + loanId));

		loan.setReturnDate(LocalDate.now());
		loan.setLoanStatus("RETURNED");

		Book book = loan.getBook();
		book.setCopiesAvailable(book.getCopiesAvailable() + 1);
		bookRepository.save(book);

		return loanRepository.save(loan);
	}

	@Override
	public Loan getLoanById(Long loanId) {
		return loanRepository.findById(loanId)
				.orElseThrow(() -> new ResourceNotFoundException("laon not found with id " + loanId));
	}

	@Override
	public List<Loan> getLoansByMember(Long memberId) {
		return loanRepository.findByMemberMemberId(memberId);
	}

	@Override
	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
	}

}
