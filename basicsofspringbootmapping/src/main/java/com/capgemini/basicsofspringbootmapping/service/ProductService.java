package com.capgemini.basicsofspringbootmapping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.basicsofspringbootmapping.dto.ProductDto;
import com.capgemini.basicsofspringbootmapping.dto.ProductMapper;
import com.capgemini.basicsofspringbootmapping.entity.Product;
import com.capgemini.basicsofspringbootmapping.repository.ProductJpaRepository;

@Service
public class ProductService {

    @Autowired
    ProductJpaRepository jpa;

    // Create a product using DTO
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.toEntity(productDto);
        Product savedProduct = jpa.save(product);
        return ProductMapper.toDto(savedProduct);
    }

    // Find a product by ID and return as DTO
    public ProductDto getProductById(Integer id) {
        Product product = jpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return ProductMapper.toDto(product);
    }

    // Find all products and return as list of DTOs
    public List<ProductDto> getAllProducts() {
        List<Product> products = jpa.findAll();
        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

}
