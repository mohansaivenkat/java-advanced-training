package com.example.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	List<Loan> findByMemberMemberId(Long memberId);

}
