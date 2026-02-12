package basicsofhibernate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.assessments.Person;
import com.assessments.PersonCRUD;

import java.time.LocalDate;

public class PersonCrudTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    @BeforeEach
    void setup() {
    
        emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @AfterEach
    void tearDown() {
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }

    @Test
    void testAddPerson() {
        Person p = new Person();
        p.setId(101);
        p.setName("Mohan");
        p.setDob(LocalDate.of(1998, 5, 20));
        p.setAddress("Mumbai");
        p.setPincode("400001");

        String response = PersonCRUD.addPerson(et, em, p);
        
        assertEquals("Data Added", response);
        Person saved = em.find(Person.class, 101);
        assertNotNull(saved);
        assertEquals("Mohan", saved.getName());
    }

    @Test
    void testUpdatePerson() {
        Person p = new Person();
        p.setId(1);
        p.setName("Original Name");
        p.setDob(LocalDate.of(2000, 1, 1));
        
        et.begin();
        em.persist(p);
        et.commit();

        String response = PersonCRUD.updatePerson(et, em, 1);
        em.clear(); 
        Person updated = em.find(Person.class, 1);
        
        assertEquals("hero", updated.getName());
        assertTrue(response.contains("Update details"));
    }

    @Test
    void testFindById() {
        Person p = new Person();
        p.setId(5);
        p.setName("Test User");
        p.setDob(LocalDate.now());

        et.begin();
        em.persist(p);
        et.commit(); 

        Person found = PersonCRUD.findById(et, em, 5);
        
        assertNotNull(found);
        assertEquals("Test User", found.getName());
    }

    @Test
    void testDeletePerson() {
        Person p = new Person();
        p.setId(10);
        p.setName("Temporary");
        
        et.begin();
        em.persist(p);
        et.commit();

        Person deleted = PersonCRUD.deletePersonByID(et, em, 10);
        
        assertNotNull(deleted);
       
    }
}