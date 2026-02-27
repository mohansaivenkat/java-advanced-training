package com.springboot.basicsofspringboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface CarJpaRepository extends JpaRepository<Car, Integer> {
	public List<Car> getByBrand(String s);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM car where brand=:carbrand",nativeQuery = true)
	public Integer deleteCarByBrand(@Param("carbrand") String brand);
	
}
