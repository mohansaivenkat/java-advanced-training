package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dao.AuthorRepository;
import com.example.library.entity.Author;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author getAuthorById(Long authorId) {
		return authorRepository.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("auther not found with id " + authorId));
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author updateAuthor(Long authorId, Author updatedAuthor) {
		Author existing = authorRepository.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("auther not found with id " + authorId));
		existing.setName(updatedAuthor.getName());
		existing.setBiography(updatedAuthor.getBiography());
		return authorRepository.save(existing);
	}

	@Override
	public void deleteAuthor(Long authorId) {
		Author existing = authorRepository.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("auther not found with id " + authorId));
		authorRepository.delete(existing);
	}

}
