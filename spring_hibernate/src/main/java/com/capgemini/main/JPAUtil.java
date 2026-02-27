package com.capgemini.main;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;


@Component
public class JPAUtil {

	EntityManagerFactory emf;

	private EntityManager em;

	@PostConstruct
	public void init() {
		System.out.println("Display");
		emf = Persistence.createEntityManagerFactory("postgres");
		setEm(emf.createEntityManager());
		System.out.println("JPA Connection Created Successfully!");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Print");
		getEm().close();
		emf.close();
		System.out.println("JPA Connection Closed.");
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
}
