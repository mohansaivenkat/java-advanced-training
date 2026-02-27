package com.product_case_study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product_case_study.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProductNameContainingIgnoreCase(String productName);

	List<Product> findByCategoryCategoryId(Integer categoryId);
}
