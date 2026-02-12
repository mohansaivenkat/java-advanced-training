package com.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		ProductCRUD pd = new ProductCRUD();
		
		Product p = new Product();
		
		p.setId(101);
		p.setName("Soap");
		p.setPrice(80);
		p.setQuantity(250);
		
		
		pd.addProducts(et, em,p);
//		pd.updateProducts(et, em);
//		pd.deleteProducts(et, em);
//		pd.findById(et, em);
//		pd.findAllProduct(et, em);
		
		
	}
}
