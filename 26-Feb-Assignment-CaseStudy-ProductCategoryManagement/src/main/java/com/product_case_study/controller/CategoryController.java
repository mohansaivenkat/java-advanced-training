package com.product_case_study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product_case_study.entity.Category;
import com.product_case_study.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category savedCategory = categoryService.createCategory(category);
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categories = categoryService.getAllCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable Integer categoryId, @RequestBody Category category) {
		Category updatedCategory = categoryService.updateCategory(categoryId, category);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer categoryId) {
		String message = categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/page")
	public List<Category> getCategory(@RequestParam int page, @RequestParam int size) {
		return categoryService.getCategories(page, size);
	}

	@GetMapping("/sort")
	public List<Category> sortById(@RequestParam int page, @RequestParam int size) {
		return categoryService.getSort(page, size);
	}

}
