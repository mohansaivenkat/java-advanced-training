package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo2DeleteStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Student s = em.find(Student.class, 101);
		
		System.out.println(s.getId()+" "+s.getName()+" "+s.getPercentage());
		
		et.begin();
			em.remove(s);
		et.commit();
		

	}

}
