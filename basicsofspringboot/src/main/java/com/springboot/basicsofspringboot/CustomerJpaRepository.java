package com.springboot.basicsofspringboot;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer,Integer>{
	
	public Optional<Customer> findByEmail(String email);
	public Optional<Customer> findByName(String Name);
	
	public List<Customer> findByAgeBetween(Integer start,Integer end);
	
	public List<Customer> findTop10ByOrderByIdAsc();

}
