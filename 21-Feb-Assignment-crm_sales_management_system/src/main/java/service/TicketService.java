package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Order;
import entity.SupportTicket;

public class TicketService {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");
	
	public void raiseTicket(Long orderId, String issueDescription) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Order o = em.find(Order.class, orderId);
		SupportTicket t = new SupportTicket();
		
		t.setOrder(o);
		t.setIssueDescription(issueDescription);
		t.setStatus("ACTIVE");
		
		em.persist(t);
		
		et.commit();
		em.close();
				
	}
}
