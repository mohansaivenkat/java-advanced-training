package many_to_many_mapping;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Subject sub1 = new Subject();
//		sub1.setSub_id(101);
//		sub1.setName("Maths");
//		sub1.setNumOfDays(10);
//		
//		
//		Subject sub2 = new Subject();
//		sub2.setSub_id(102);
//		sub2.setName("Python");
//		sub2.setNumOfDays(20);
//		
//		
//		Subject sub3 = new Subject();
//		sub3.setSub_id(103);
//		sub3.setName("Java");
//		sub3.setNumOfDays(30);
//		
//		
//		
//		Student s1 = new Student();
//		s1.setName("Mohan");
//		s1.setGender("Male");
//		s1.setBranch("CSE");
//		List<Subject> l = new ArrayList<Subject>();
//		l.add(sub1);
//		l.add(sub2);
//		l.add(sub3);
//		
//		s1.setSubject(l);
//		
//		Student s2 = new Student();
//		s2.setName("Priya");
//		s2.setGender("Female");
//		s2.setBranch("ECE");
//		List<Subject> l2 = new ArrayList<Subject>();
//		l2.add(sub2);
//		l2.add(sub3);
//		
//		s2.setSubject(l2);
//		
//		et.begin();
//			em.persist(sub1);
//			em.persist(sub2);
//			em.persist(sub3);
//			
//			em.persist(s1);
//			em.persist(s2);
//		et.commit();
		
		
		
			String sql1 = "delete from student_subject where subject_sub_id = ?1";
			Query query1 = em.createNativeQuery(sql1);
			query1.setParameter(1, 103);
			
			String sql2 = "delete from subject where sub_id = ?1";
			Query query2 = em.createNativeQuery(sql2);
			query2.setParameter(1, 103);
			
			et.begin();
				query1.executeUpdate();
				query2.executeUpdate();
			et.commit();
		
		
		
		
	}

}
