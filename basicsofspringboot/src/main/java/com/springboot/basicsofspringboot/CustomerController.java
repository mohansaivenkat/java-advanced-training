package com.springboot.basicsofspringboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerJpaRepository custjpa;
	
	@PostMapping("create-customer")
	public List<Customer> createCustomer(@RequestBody List<Customer> c) {
		custjpa.saveAll(c);
		return c;
	}
	
	@GetMapping("find-by-id/{id}")
	public String findById(@PathVariable Integer id) {
		Optional<Customer> cust = custjpa.findById(id); 
		if(cust.isPresent()) {
			return cust.get().toString();
		}
		else {
			return "Customer with id: "+id+" not found";
		}
	}
	
	@DeleteMapping("delete-by-id/{id}")
	public Boolean deleteById(@PathVariable Integer id) {
		Optional<Customer> cust=custjpa.findById(id);
		if(cust.isPresent()) {
			custjpa.delete(cust.get());
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//now built-in methods
	
	@GetMapping("find-by-email/{email}")
	public String findByEmail(@PathVariable String email) {
		Optional<Customer> cust = custjpa.findByEmail(email); 
		if(cust.isPresent()) {
			return cust.get().toString();
		}
		else {
			return "Customer with email: "+email+" not found";
		}
	}
	
	@GetMapping("find-by-name/{name}")
	public String findByName(@PathVariable String name) {
		Optional<Customer> cust = custjpa.findByName(name); 
		if(cust.isPresent()) {
			return cust.get().toString();
		}
		else {
			return "Customer with name: "+name+" not found";
		}
	}
	
	@GetMapping("find-by-age-range/{ageRange}") // 18-65
	public List<Customer> findByAgeRange(@PathVariable String ageRange) {
		
		String arr[] = ageRange.split("-");
		return custjpa.findByAgeBetween(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])); 
		
	}
	
	@GetMapping("find-by-top10-byid")
	public List<Customer> findTop10ByIdAsc(){
		return custjpa.findTop10ByOrderByIdAsc();
	}

	
	
	
	

}
