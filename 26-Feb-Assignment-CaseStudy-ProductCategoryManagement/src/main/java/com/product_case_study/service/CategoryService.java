package com.product_case_study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.product_case_study.entity.Category;
import com.product_case_study.exception.CategoryNotFoundException;
import com.product_case_study.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Optional<Category> getCategoryById(Integer categoryId) {
		Optional<Category>category = categoryRepository.findById(categoryId);
//		if (!category.isPresent()) {
//			throw new CategoryNotFoundException("category not found with id " + categoryId);
//		}
		return category;
	}

	public Category updateCategory(Integer categoryId, Category updatedCategory) {
		Category existingCategory = categoryRepository.findById(categoryId).orElse(null);
		if (existingCategory == null) {
			throw new CategoryNotFoundException("category not found with id " + categoryId);
		}
		existingCategory.setCategoryName(updatedCategory.getCategoryName());
		existingCategory.setDescription(updatedCategory.getDescription());
		return categoryRepository.save(existingCategory);
	}

	public String deleteCategory(Integer categoryId) {
		Category category = categoryRepository.findById(categoryId).orElse(null);
		if (category == null) {
			throw new CategoryNotFoundException("category not found with id " + categoryId);
		}
		categoryRepository.delete(category);
		return "category deleted successfully with id " + categoryId;
	}
	
	
	public List<Category> getCategories(int page, int size) {

        Page<Category> categoryPage =
                categoryRepository.findAll(PageRequest.of(page, size));

        return categoryPage.getContent();
    }
    
    public List<Category> getSort(int page, int size){
        Page<Category> categoryPage =
                categoryRepository.findAll(PageRequest.of(page, size, Sort.by("categoryId").descending()));

        return categoryPage.getContent();
    }

}
