package com.product_case_study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_case_study.entity.Category;
import com.product_case_study.entity.Product;
import com.product_case_study.exception.CategoryNotFoundException;
import com.product_case_study.exception.InvalidProductDataException;
import com.product_case_study.exception.ProductNotFoundException;
import com.product_case_study.repository.CategoryRepository;
import com.product_case_study.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public Product createProduct(Product product, Integer categoryId) {
		if (product.getProductName() == null || product.getProductName().isEmpty()) {
			throw new InvalidProductDataException("product name must not be empty");
		}
		if (product.getPrice() == null || product.getPrice() <= 0) {
			throw new InvalidProductDataException("product price must be positive");
		}
		Category category = categoryRepository.findById(categoryId).orElse(null);
		if (category == null) {
			throw new CategoryNotFoundException("category not found with id " + categoryId);
		}
		product.setCategory(category);
		return productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Integer productId) {
		Product product = productRepository.findById(productId).orElse(null);
		if (product == null) {
			throw new ProductNotFoundException("product not found with id " + productId);
		}
		return product;
	}

	public Product updateProduct(Integer productId, Product updatedProduct, Integer categoryId) {
		Product existingProduct = productRepository.findById(productId).orElse(null);
		if (existingProduct == null) {
			throw new ProductNotFoundException("product not found with id " + productId);
		}
		if (updatedProduct.getProductName() == null || updatedProduct.getProductName().isEmpty()) {
			throw new InvalidProductDataException("product name must not be empty");
		}
		if (updatedProduct.getPrice() == null || updatedProduct.getPrice() <= 0) {
			throw new InvalidProductDataException("product price must be positive");
		}
		Category category = categoryRepository.findById(categoryId).orElse(null);
		if (category == null) {
			throw new CategoryNotFoundException("category not found with id " + categoryId);
		}
		existingProduct.setProductName(updatedProduct.getProductName());
		existingProduct.setPrice(updatedProduct.getPrice());
		existingProduct.setCategory(category);
		return productRepository.save(existingProduct);
	}

	public String deleteProduct(Integer productId) {
		Product product = productRepository.findById(productId).orElse(null);
		if (product == null) {
			throw new ProductNotFoundException("product not found with id " + productId);
		}
		productRepository.delete(product);
		return "product deleted successfully with id " + productId;
	}

	public List<Product> getProductsByCategoryId(Integer categoryId) {
		Category category = categoryRepository.findById(categoryId).orElse(null);
		if (category == null) {
			throw new CategoryNotFoundException("category not found with id " + categoryId);
		}
		return productRepository.findByCategoryCategoryId(categoryId);
	}

	public List<Product> searchProductByName(String productName) {
		return productRepository.findByProductNameContainingIgnoreCase(productName);
	}
}
