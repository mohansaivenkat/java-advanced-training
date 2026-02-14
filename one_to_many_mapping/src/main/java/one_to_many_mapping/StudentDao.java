package one_to_many_mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public static void saveStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.persist(student);
        et.commit();
        em.close();
    }

    public static Student findStudent(Integer id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }
    
    public static void deleteStudent(Integer id) {
    	EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
    	Student s = em.find(Student.class, id);
    	
    	
    	String sql1 = "delete from college_student where student_s_id =?1 ";
    	String sql2 = "delete from student where s_id=?1";
    	
    	//delete query for joined one_to_many
    	Query query1 = em.createNativeQuery(sql1);
    	query1.setParameter(1, id);
    	
    	//delete query for student
    	Query query2 = em.createNativeQuery(sql2);
    	query2.setParameter(1, id);
    	
    	et.begin();
    		query1.executeUpdate();
    		query2.executeUpdate();
    	et.commit();	
    }
    
    
} 