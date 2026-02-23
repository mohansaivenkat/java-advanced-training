package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Customer;
import entity.Lead;
import entity.SalesEmployee;

public class LeadService {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");
	
	public void createLead(String name, String source, String contactInfo,String email) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Lead l = new Lead();
		l.setName(name);
		l.setSource(source);
		l.setContactInfo(contactInfo);
		l.setEmail(email);
		l.setStatus("ACTIVE");
		
		em.persist(l);
		et.commit();
		em.close();
	}
	
	public void assignLeadToEmployee(Long leadId,Long employeeId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Lead l = em.find(Lead.class, leadId);
		SalesEmployee s = em.find(SalesEmployee.class, employeeId);
		
		l.setEmployee(s);
		
		em.merge(l);
		et.commit();
		em.close();
	}
	
	public void convertLeadToCustomer(Long leadId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Lead l = em.find(Lead.class, leadId);
		Customer c = new Customer();
		c.setName(l.getName());
		c.setPhone(l.getContactInfo());
		c.setEmail(l.getEmail());
		
		l.setStatus("SUCESS");
		
		em.persist(c);
		em.merge(l);
		
		et.commit();
		em.close();
		
	
	}

}
