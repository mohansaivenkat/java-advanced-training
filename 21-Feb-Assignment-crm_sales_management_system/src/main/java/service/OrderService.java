package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Customer;
import entity.Order;
import entity.Product;

public class OrderService {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");
	
	public void placeOrder(Long customerId, List<Long> productIds) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Order o = new Order();
		Customer c = em.find(Customer.class, customerId);
		
		List<Product> productList = new ArrayList<>();
        double total = 0;
        
        for (Long pId : productIds) {
            Product p = em.find(Product.class, pId);
            if (p != null) {
                productList.add(p);
                total += p.getPrice();
            }
        }
        
		o.setProducts(productList);
		o.setCustomer(c);
		
		o.setOrderDate(LocalDate.now().toString());
		
		o.setTotalAmount(total);
		
		em.persist(o);
		et.commit();
		em.close();
	}
}
