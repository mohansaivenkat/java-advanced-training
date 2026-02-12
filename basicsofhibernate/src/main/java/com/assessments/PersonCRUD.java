package com.assessments;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.product.Product;

public class PersonCRUD {
	
public static String addPerson(EntityTransaction et, EntityManager em,Person p) {
		
		if(p!=null) {
			et.begin();
			em.persist(p);
			et.commit();
			return "Data Added";
		}
		else {
			return "Empty Data";
		}
		
	}
	
	public static String updatePerson(EntityTransaction et, EntityManager em,Integer id) {
		Person product = em.find(Person.class, id);
		
		if(product != null) {
			product.setName("hero");
			et.begin();
			em.merge(product);
			et.commit();
			return "Update details for Person with id : "+id;
		}else {
			return "Data Missing with mentioned id : "+id;
		}
			
	}
	
	public static Person deletePersonByID(EntityTransaction et, EntityManager em,Integer id) {
		Person p = em.find(Person.class, id);
		
		if(p != null) {
			et.begin();
			em.remove(p);
			et.commit();
			return p;
		}
		else {
			System.out.println("Data doesn't exist");
			return null;
		}
	}
	
	public static Person findById(EntityTransaction et, EntityManager em,Integer id) {
		Person p = em.find(Person.class, id);
		if(p !=null) {
			System.out.println("Person [id=" + id + ", name=" + p.getName() + ", dob=" + p.getDob().toString() + ", address=" + p.getAddress() 
			+ ", pincode=" + p.getPincode()
					+ "]");
			return p;
		}
		else {
			System.out.println("Data Not Found");
			return null;
		}
		
	}
	
	

}
