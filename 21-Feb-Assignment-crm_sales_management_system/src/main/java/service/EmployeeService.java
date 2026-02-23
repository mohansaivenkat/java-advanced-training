package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.SalesEmployee;

public class EmployeeService {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");

	public void addEmployee(String name, String department) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		SalesEmployee emp = new SalesEmployee();
		emp.setName(name);
		emp.setDepartment(department);

		em.persist(emp);
		et.commit();
		em.close();
	}
}
