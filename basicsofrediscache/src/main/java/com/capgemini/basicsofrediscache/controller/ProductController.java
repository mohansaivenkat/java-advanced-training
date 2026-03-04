package com.capgemini.basicsofrediscache.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.basicsofrediscache.entity.FileData;
import com.capgemini.basicsofrediscache.entity.Product;
import com.capgemini.basicsofrediscache.service.ProductService;

@RestController
public class ProductController {
	
	private ProductService prodserv;
	
	public ProductController(ProductService p) {
		this.prodserv = p;
	}
	
	
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product p) {
		return prodserv.addProduct(p);
	}
	
	@GetMapping("/find-id/{id}")
	public Product getProductById(@PathVariable Integer id) {
		return prodserv.getById(id);
	}
	
	
	

}
