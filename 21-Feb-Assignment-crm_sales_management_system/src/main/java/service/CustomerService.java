package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Address;
import entity.Customer;

public class CustomerService {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");
//	private static EntityTransaction et=em.getTransaction();

	public void registerCustomer(String name, String email, String phone) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Customer c = new Customer();
		c.setEmail(email);
		c.setName(name);
		c.setPhone(phone);

		em.persist(c);
		et.commit();

		em.close();
	}

	public void addAddressToCustomer(Long customerId, Address address) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Customer c = em.find(Customer.class, customerId);

		c.setAddress(address);
		
		em.merge(c);
		et.commit();
		
		em.close();

	}

}
