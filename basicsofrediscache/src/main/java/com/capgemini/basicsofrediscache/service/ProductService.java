package com.capgemini.basicsofrediscache.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.capgemini.basicsofrediscache.entity.Product;
import com.capgemini.basicsofrediscache.repository.ProductJpaRepository;

@Service
public class ProductService {
	
	ProductJpaRepository prodjpa;
	
	public ProductService(ProductJpaRepository prodjpa) {
		this.prodjpa=prodjpa;
	}
	
	@CachePut(cacheNames = "product", key="#result.id")
	public Product addProduct(Product p) {
		return prodjpa.save(p);
	}
	
	@Cacheable(cacheNames = "product" , key = "#id")
	public Product getById(Integer id) {
		return prodjpa
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Id not found"));
	}

}
