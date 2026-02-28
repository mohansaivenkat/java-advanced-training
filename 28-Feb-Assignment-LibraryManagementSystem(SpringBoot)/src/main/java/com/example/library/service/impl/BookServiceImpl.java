package com.example.library.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dao.AuthorRepository;
import com.example.library.dao.BookRepository;
import com.example.library.dao.CategoryRepository;
import com.example.library.dao.LibraryBranchRepository;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Category;
import com.example.library.entity.LibraryBranch;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private LibraryBranchRepository branchRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Book addBook(Book book, Long categoryId, Long branchId, Set<Long> authorIds) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("categroy not found with id " + categoryId));
		LibraryBranch branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("brnach not found with id " + branchId));
		Set<Author> authors = new HashSet<>(authorRepository.findAllById(authorIds));
		book.setCategory(category);
		book.setBranch(branch);
		book.setAuthors(authors);
		book.setStatus("ACTIVE");
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Long bookId) {
		return bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("bok not found with id " + bookId));
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Long bookId, Book updatedBook) {
		Book existing = bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("bok not found with id " + bookId));
		existing.setTitle(updatedBook.getTitle());
		existing.setIsbn(updatedBook.getIsbn());
		existing.setPublishYear(updatedBook.getPublishYear());
		existing.setCopiesTotal(updatedBook.getCopiesTotal());
		existing.setCopiesAvailable(updatedBook.getCopiesAvailable());
		return bookRepository.save(existing);
	}

	@Override
	public void deleteOrDisableBook(Long bookId) {
		Book existing = bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("bok not found with id " + bookId));
		existing.setStatus("INACTIVE");
		bookRepository.save(existing);
	}

}
