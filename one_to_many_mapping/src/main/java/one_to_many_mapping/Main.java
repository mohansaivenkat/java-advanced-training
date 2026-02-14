package one_to_many_mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		
//		//creating student objects
//		Student s1 = new Student();
//		s1.setStudent_id(101);
//		s1.setName("Mohan");
//		s1.setBranch("CSE");
//		
//		Student s2 = new Student();
//		s2.setStudent_id(102);
//		s2.setName("Rohit");
//		s2.setBranch("CSE");
//		
//		Student s3 = new Student();
//		s3.setStudent_id(103);
//		s3.setName("Dinesh");
//		s3.setBranch("ECE");
//		
//		
//		//creating and adding student objects to lists
//		List<Student> l = new ArrayList<>();
//		
//		l.add(s1);
//		l.add(s2);
//		l.add(s3);
//		
//		College c = new College();
//		c.setCollege_id(1);
//		c.setName("LPU");
//		c.setLocation("Punjab");
//		c.setPincode("144001");
//		c.setStudent(l);
//		
//		et.begin();
//			em.persist(c);
//			em.persist(s1);
//			em.persist(s2);
//			em.persist(s3);
//		et.commit();
		
		
//		College c = new College();
//		c.setCollege_id(2);
//		c.setName("SRM");
//		c.setLocation("Chennai");
//		c.setPincode("188292");
//		
//		
//		
//		Student s = new Student();
//		s.setName("Jeevan");
//		s.setStudent_id(105);
//		s.setBranch("Mech");
//		
//		List<Student> v = new ArrayList<Student>();
//		v.add(s);
//		
//		CollegeDao.saveCollege(c, v);
		
		StudentDao.deleteStudent(105);
		
		
		

	}

}
