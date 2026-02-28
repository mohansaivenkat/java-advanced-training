package com.example.library.service;

import java.util.List;

import com.example.library.entity.Author;

public interface AuthorService {

	Author addAuthor(Author author);

	Author getAuthorById(Long authorId);

	List<Author> getAllAuthors();

	Author updateAuthor(Long authorId, Author updatedAuthor);

	void deleteAuthor(Long authorId);

}
