package com.mockito;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;



public class UsersDao {
	
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();
	
	public void insertUser() {

		Users e = new Users();
		
		e.setId(2);
		e.setName("Jeevan");
		e.setBalance(40000);
		
		et.begin();
		em.persist(e);
		et.commit();
	}
	
	public Users findUserById(Integer id) {
		Users u = em.find(Users.class, id);
		
		System.out.println(u);
		
		return u;
	}

}
