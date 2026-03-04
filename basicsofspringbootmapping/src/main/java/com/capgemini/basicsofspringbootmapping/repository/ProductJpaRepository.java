package com.capgemini.basicsofspringbootmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.basicsofspringbootmapping.entity.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

}
