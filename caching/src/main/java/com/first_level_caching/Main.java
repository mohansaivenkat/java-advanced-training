package com.first_level_caching;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.second_level_caching.Item;

public class Main {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public static void main(String[] args) {
		read();
	}
	
	public static void insert() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product p1 = new Product(1, "Book");
		Product p2 = new Product(2, "Pencil");
		
		et.begin();
		em.persist(p1);
		em.persist(p2);
		et.commit();
		
	}
	
	public static void read() {
	    System.out.println("--- Starting First-Level Cache Test ---");
	    EntityManager em1 = emf.createEntityManager();
	    
	    // FETCH 1: Hits the Database
	    System.out.println("EM1: First fetch for Item 1...");
	    Product i1 = em1.find(Product.class, 1); 
	    
	    System.out.println(i1);
	    
	    // FETCH 2: Hits the L1 Cache (No SQL in console)
	    System.out.println("EM1: Second fetch for Item 1 (L1 Cache check)...");
	    Product i2 = em1.find(Product.class, 1); 
	    System.out.println(i2);
	    
	    em1.close(); // L1 Cache is cleared here!
	    System.out.println("--- EM1 Closed. L1 Cache is now empty. ---");

	    System.out.println("\n--- Starting Second-Level Cache Test ---");
	    EntityManager em2 = emf.createEntityManager();

	    // FETCH 3: If L2 is enabled, this will NOT hit the database.
	    // If L2 is disabled, this WILL hit the database because EM1 is closed.
	    System.out.println("EM2: Fetching Item 1 after EM1 closed...");
	    Product i3 = em2.find(Product.class, 1);
	    System.out.println(i3);

	    em2.close();
	}
	
}