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

import com.product_case_study.entity.Product;
import com.product_case_study.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/{categoryId}")
	public ResponseEntity<Product> createProduct(@RequestBody Product product, @PathVariable Integer categoryId) {
		Product savedProduct = productService.createProduct(product, categoryId);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
		Product product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PutMapping("/{productId}/category/{categoryId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody Product product, @PathVariable Integer categoryId) {
		Product updatedProduct = productService.updateProduct(productId, product, categoryId);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer productId) {
		String message = productService.deleteProduct(productId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Integer categoryId) {
		List<Product> products = productService.getProductsByCategoryId(categoryId);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProductByName(@RequestParam String name) {
		List<Product> products = productService.searchProductByName(name);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
