import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.Student;
import com.assignment.StudentDao;

public class StudentDaoTest {

    static EntityManagerFactory emf;
    EntityManager em;
    StudentDao dao;

    @BeforeAll
    public static void start() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    public void setup() {
        em = emf.createEntityManager();
        dao = new StudentDao(em); 
    }

    @Test
    public void testSaveStudent() {
        Student s = new Student();
        s.setId(1);
        s.setName("John");
        s.setEmail("john@mail.com");
        s.setMarks(80.0);

        dao.saveStudent(s);

        Student saved = em.find(Student.class, 1);
        assertNotNull(saved);
        assertEquals("John", saved.getName());
    }

    @Test
    public void testFindStudentById() {
        Student s = new Student();
        s.setId(2);
        s.setName("Smith");
        s.setEmail("smith@mail.com");
        dao.saveStudent(s);

        Student found = dao.findStudentById(2);
        assertNotNull(found);
        assertEquals("smith@mail.com", found.getEmail());
    }

    @Test
    public void testFindAllStudents() {
        Student s1 = new Student();
        s1.setId(3);
        s1.setName("User1");
        s1.setEmail("u1@mail.com");
        dao.saveStudent(s1);

        Student s2 = new Student();
        s2.setId(4);
        s2.setName("User2");
        s2.setEmail("u2@mail.com");
        dao.saveStudent(s2);

        List<Student> list = dao.findAllStudents();
        assertTrue(list.size() >= 2);
    }

    @Test
    public void testUpdateStudent() {
        Student s = new Student();
        s.setId(5);
        s.setName("Old Name");
        s.setEmail("old@mail.com");
        dao.saveStudent(s);

        s.setName("New Name");
        dao.updateStudent(s);

        Student updated = dao.findStudentById(5);
        assertEquals("New Name", updated.getName());
    }

    @Test
    public void testDeleteStudent() {
        Student s = new Student();
        s.setId(6);
        s.setName("Delete Me");
        s.setEmail("delete@mail.com");
        dao.saveStudent(s);

        dao.deleteStudent(6L);

        Student deleted = dao.findStudentById(6);
        assertNull(deleted);
    }

    @Test
    public void testStudentCount() {
        int before = dao.findAllStudents().size();

        Student s = new Student();
        s.setId(7);
        s.setName("Counter");
        s.setEmail("count@mail.com");
        dao.saveStudent(s);

        int after = dao.findAllStudents().size();
        assertEquals(before + 1, after);
    }

    @AfterEach
    public void clean() {
        em.close();
    }

    @AfterAll
    public static void stop() {
        emf.close();
    }
}