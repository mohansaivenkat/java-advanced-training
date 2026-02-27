package com.springboot.basicsofspringboot;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	public CarJpaRepository carjpa;

	@PostMapping("/api")
	public Set<String> hello() {
		return Set.of("Miller", "Bravis", "Makram"); // JSON collection
	}

	@PostMapping("/add")
	public String createCricketer(@RequestBody Cricketer c) {

		System.out.println(c);
		return c.toString();
	}

	@PostMapping("/car")
	public String createCar(@RequestBody Car c) {

		System.out.println(c);
		return c.toString();
	}

	@PostMapping("/car1")
	public List<Car> createCar1(@RequestBody List<Car> c) {

		return carjpa.saveAll(c);
		
	}

	@GetMapping("/find-id")
	public String findById(@RequestParam Integer id) {

		Optional<Car> car = carjpa.findById(id);
		
		if(car.isPresent()) {
			return car.get().toString();
		}
		else {
			throw new CarDataDoesNotExistException();
		}
		
	}
	
	@GetMapping("/find-all")
	public List<Car> findAll() {

		return carjpa.findAll();
		
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable Integer id) {
		Optional<Car> car = carjpa.findById(id);
		if(car.isPresent()) {
			carjpa.delete(car.get());
			return "Car with id: "+id+" is deleted";
		}
		else {
			return "Car with id: "+id+" not found";
		}
	}
	
	@PutMapping("/update-car/{id}")
	public String updateCar(@PathVariable Integer id,@RequestBody Car c) {
		Optional<Car> option = carjpa.findById(id);
		if(option.isPresent()) {
			Car car = option.get();
			car.setBrand(c.getBrand());
			car.setModel(c.getModel());
			carjpa.save(car);
			return "Car with id: "+id+" is updated";
		}
		else {
			return "Car with id: "+id+" is not found";
		}
	}
	
	@PatchMapping("/partialupdate-car/{id}")
	public Boolean updateCarData(@PathVariable Integer id,@RequestBody Car c) {
		Optional<Car> option = carjpa.findById(id);
		
		if(option.isPresent()) {
			Car car = option.get();
			if(car.getBrand() != null) {
				car.setBrand(c.getBrand());
			}
			if (c.getModel() != null) {
				car.setModel(c.getModel());
			}
			
			carjpa.save(car);
			return true;
		}
		else {
			return false;
		}
	}
	
	@GetMapping("/find-by-brand/{s}")
	public List<Car> getCarByBrand(@PathVariable String s) {
		return carjpa.getByBrand(s);
	}
	
	@DeleteMapping("/delete-by-brand/{s}")
	public Integer deleteCarByBrand(@PathVariable String s) {
		return carjpa.deleteCarByBrand(s);
	}
	
	
	

}
