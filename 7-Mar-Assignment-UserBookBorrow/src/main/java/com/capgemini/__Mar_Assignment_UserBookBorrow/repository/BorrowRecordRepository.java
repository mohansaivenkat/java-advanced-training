package com.capgemini.__Mar_Assignment_UserBookBorrow.repository;

import com.capgemini.__Mar_Assignment_UserBookBorrow.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}
