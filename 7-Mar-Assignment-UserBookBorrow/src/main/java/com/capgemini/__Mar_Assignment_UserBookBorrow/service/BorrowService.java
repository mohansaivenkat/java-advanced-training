package com.capgemini.__Mar_Assignment_UserBookBorrow.service;

import com.capgemini.__Mar_Assignment_UserBookBorrow.entity.Book;
import com.capgemini.__Mar_Assignment_UserBookBorrow.entity.BorrowRecord;
import com.capgemini.__Mar_Assignment_UserBookBorrow.entity.User;
import com.capgemini.__Mar_Assignment_UserBookBorrow.repository.BookRepository;
import com.capgemini.__Mar_Assignment_UserBookBorrow.repository.BorrowRecordRepository;
import com.capgemini.__Mar_Assignment_UserBookBorrow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public BorrowRecord borrowBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (user == null || book == null || !book.isAvailable()) {
            return null;
        }

        BorrowRecord record = new BorrowRecord();
        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setReturned(false);

        book.setAvailable(false);
        bookRepository.save(book);

        return borrowRecordRepository.save(record);
    }

    public BorrowRecord returnBook(Long recordId) {
        BorrowRecord record = borrowRecordRepository.findById(recordId).orElse(null);

        if (record == null || record.isReturned()) {
            return null;
        }

        record.setReturned(true);
        record.setReturnDate(LocalDate.now());

        Book book = record.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        return borrowRecordRepository.save(record);
    }

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    public BorrowRecord getBorrowRecordById(Long id) {
        return borrowRecordRepository.findById(id).orElse(null);
    }
}
