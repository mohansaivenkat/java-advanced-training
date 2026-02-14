package one_to_many_mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class CollegeDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public static void saveCollege(College college, List<Student> students) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        
        // 1. Persist each student first (if they aren't already in DB)
        for (Student s : students) {
            em.persist(s);
        }
        
        // 2. Assign the list to the college and persist
        college.setStudent(students);
        em.persist(college);
        
        et.commit();
        em.close();
    }

    public static College getCollegeDetails(Integer id) {
        EntityManager em = emf.createEntityManager();
        College college = em.find(College.class, id);
        // By default, OneToMany is Lazy, so accessing the list here initializes it
        if(college != null) {
            college.getStudent().size(); 
        }
        em.close();
        return college;
    }
    
   
}