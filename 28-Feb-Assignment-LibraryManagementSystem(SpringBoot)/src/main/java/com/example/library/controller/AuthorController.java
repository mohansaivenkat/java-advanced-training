package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Author;
import com.example.library.service.AuthorService;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
		return ResponseEntity.ok(authorService.addAuthor(author));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
		return ResponseEntity.ok(authorService.getAuthorById(id));
	}

	@GetMapping
	public ResponseEntity<List<Author>> getAllAuthors() {
		return ResponseEntity.ok(authorService.getAllAuthors());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
		return ResponseEntity.ok(authorService.updateAuthor(id, author));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);
		return ResponseEntity.ok("auther deletd succesfully");
	}

}
