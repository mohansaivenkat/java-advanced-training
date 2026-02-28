package com.example.library.service;

import java.util.List;
import java.util.Set;

import com.example.library.entity.Book;

public interface BookService {

	Book addBook(Book book, Long categoryId, Long branchId, Set<Long> authorIds);

	Book getBookById(Long bookId);

	List<Book> getAllBooks();

	Book updateBook(Long bookId, Book updatedBook);

	void deleteOrDisableBook(Long bookId);

}
