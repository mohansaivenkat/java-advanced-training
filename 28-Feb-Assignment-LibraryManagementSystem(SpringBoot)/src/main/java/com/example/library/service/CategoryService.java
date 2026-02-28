package com.example.library.service;

import java.util.List;

import com.example.library.entity.Category;

public interface CategoryService {

	Category addCategory(Category category);

	Category getCategoryById(Long categoryId);

	List<Category> getAllCategories();

	Category updateCategory(Long categoryId, Category updatedCategory);

	void deleteCategory(Long categoryId);

}
