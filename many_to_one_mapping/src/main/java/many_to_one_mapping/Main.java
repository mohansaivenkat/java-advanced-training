package many_to_one_mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em =emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department dept = new Department();
//		dept.setId(101);
		dept.setManagerName("Allen");
		dept.setName("HR");
		dept.setNumOfEmployees(5);
		
		Employee e1 = new Employee("Miller", 109000.00, "ASE");
		e1.setDepartment(dept);
		
		Employee e2 = new Employee("Virat", 200000.00, "Analyst");
		e2.setDepartment(dept);
		
		et.begin();
		em.persist(dept);
		em.persist(e1);
		em.persist(e2);
		et.commit();


	}

}
