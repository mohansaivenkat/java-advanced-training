package com.capgemini.basicsofrediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.basicsofrediscache.entity.Product;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer>{

}
