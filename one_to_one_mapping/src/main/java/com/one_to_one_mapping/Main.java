package com.one_to_one_mapping;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        // 1. Define the Native SQL query
        String sql1 = "SELECT * FROM car";
        Query query = em.createNativeQuery(sql1);

        Car c1 = em.find(Car.class, 1);
        System.out.println(c1);
        
        em.clear();
        
        Car c2 = em.find(Car.class, 1);
        System.out.println(c2);
        

        em.close();
        emf.close();
    }
}
