package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dao.CategoryRepository;
import com.example.library.entity.Category;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("categroy not found with id " + categoryId));
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category updateCategory(Long categoryId, Category updatedCategory) {
		Category existing = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("categroy not found with id " + categoryId));
		existing.setName(updatedCategory.getName());
		existing.setDescription(updatedCategory.getDescription());
		return categoryRepository.save(existing);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category existing = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("categroy not found with id " + categoryId));
		categoryRepository.delete(existing);
	}

}
