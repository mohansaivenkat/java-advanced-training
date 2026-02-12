package com.assignment;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

	public class StudentDao {

	    private EntityManager em;

	    public StudentDao(EntityManager em) {
	        this.em = em;
	    }
	    
	    public void saveStudent(Student student) {
	        EntityTransaction et = em.getTransaction();
	        
	        et.begin();
	        em.persist(student);
	        et.commit();
	    }

	  
	    public Student findStudentById(Integer id) {
	        return em.find(Student.class, id);
	    }

	  
	    public List<Student> findAllStudents() {
	       Query query = em.createQuery("SELECT s FROM Student s", Student.class);
	        return query.getResultList();
	    }

	    
	    public void updateStudent(Student student) {
	        EntityTransaction et = em.getTransaction();
	        try {
	            et.begin();
	            em.merge(student); 
	            et.commit();
	        } catch (Exception e) {
	            if (et.isActive()) et.rollback();
	            e.printStackTrace();
	        }
	    }

	
	    public void deleteStudent(Long id) {
	        EntityTransaction et = em.getTransaction();
	        
	        et.begin();
	        Student student = em.find(Student.class, id);
	        if (student != null) {
	            em.remove(student);
	           }
	        et.commit();
	       
	    }
	}

