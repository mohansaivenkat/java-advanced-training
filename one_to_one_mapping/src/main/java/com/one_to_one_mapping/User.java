package com.one_to_one_mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction et = em.getTransaction();
	
	public static void main(String[] args) {
		deleteCarByEngineId();
	}
	
	public static void findCarById() {
		Car car = em.find(Car.class, 1);
		
		if (car != null) {
			System.out.println("Car Brand: " + car.getBrand());
			System.out.println("Model: " + car.getModel());
			System.out.println("Price: " + car.getPrice());
			
			Engine engine = car.getEngine();
			System.out.println("Engine Type: " + engine.getType());
			System.out.println(car);
		} else {
			System.out.println("Car not found");
		}
	}
	
	public static void deleteCarByEngineId() {
		
		et.begin();
		
		em.createQuery("update Car c set c.engine=null where c.engine.id=?1")
				.setParameter(1, 100)
				.executeUpdate();
		
		int rows = em.createQuery("delete from Engine e where e.id=?1")
						.setParameter(1, 100)
						.executeUpdate();
		
		et.commit();
		
		System.out.println(rows + "are deleted");
	}
	
	public static void insertCarAndEngine() {
		
	
		Engine e = new Engine();
		e.setId(100);
		e.setType("V8");
		e.setFuelType("petrol");
		e.setMileage("12");
		e.setCc("3000");
		
		Car c = new Car();
		c.setId(1);
		c.setBrand("Volkswagen");
		c.setModel("POLO gt10");
		c.setModelYear("2004");
		c.setPrice(20202020);
		c.setEngine(e);
		
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
		
		
	}
	
}