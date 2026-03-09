package com.capgemini.__Mar_Assignment_UserBookBorrow.service;

import com.capgemini.__Mar_Assignment_UserBookBorrow.entity.Book;
import com.capgemini.__Mar_Assignment_UserBookBorrow.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailable(true);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
