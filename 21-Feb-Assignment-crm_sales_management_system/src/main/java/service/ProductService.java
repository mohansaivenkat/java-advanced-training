package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Product;

public class ProductService {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");
	
	public void addProduct(String name, double price) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Product p = new Product();
		
		p.setPrice(price);
		p.setProductName(name);
		
		em.persist(p);
		
		et.commit();
		em.close();
		
		
	}
	

}
