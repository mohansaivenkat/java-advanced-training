package com.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class ProductMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		ProductCRUD pd = new ProductCRUD(); 
		
		//SELECT QUERIES
		
//		String jpql = "select p from Product p where p.price=?1";
//		
//		Query query = em.createQuery(jpql);
//		query.setParameter(1, 90);
//		
//		List<Product> l = query.getResultList();
//		
//		l.forEach(i -> System.out.println(i.getName()));
//		
//		String jpql2 = "select p from Product p where p.price>=?1 and p.quantity<=?2";
//		Query query2 = em.createQuery(jpql2);
//		query2.setParameter(1, 80);
//		query2.setParameter(2, 400);
//		
//		List<Product> l2 = query2.getResultList();
//		l2.forEach(i -> System.out.println("Name : "+i.getName()+"| Price : "+i.getPrice()+" | Quantity : "+i.getQuantity()));
		
		String jpql3 = "select p from Product p where p.price>=:product_price and p.quantity<=:product_quantity";
		Query query3 = em.createQuery(jpql3);
		query3.setParameter("product_price", 80);
		query3.setParameter("product_quantity", 400);
		
		List<Product> l2 = query3.getResultList();
		l2.forEach(i -> System.out.println("Name : "+i.getName()+"| Price : "+i.getPrice()+" | Quantity : "+i.getQuantity()));
	
		
		//UPDATE QUERIES
		
//		et.begin();
//		String jpql3 = "update Product p set p.price=?1 where p.price=?2";
//		Query query3 = em.createQuery(jpql3);
//		query3.setParameter(1, 95);
//		query3.setParameter(2, 90);
//		
//		
//		int rows = query3.executeUpdate();
//		et.commit();
//		
//		System.out.println(rows+" are updated");
		
		//UPDATE QUERIES - 	update using native sql // faster
		
//		String sql = "update product set price=?1 where price >=?2";
//		et.begin();
//		Query query = em.createNativeQuery(sql);
//		query.setParameter(1, 15);
//		query.setParameter(2, 10);
//		 
//		query.executeUpdate();
//		et.commit();
		
		
		
		
	}
}
