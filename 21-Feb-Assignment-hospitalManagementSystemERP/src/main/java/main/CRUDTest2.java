package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Department;
import entity.Doctor;

public class CRUDTest2 {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public static void main(String[] args) {

		saveDepartmentsAndDoctors();
		navigateBothWays();
		transferDoctor();
		jpqlQuery();
	}

	static void saveDepartmentsAndDoctors() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Department cardiology = new Department();
		cardiology.setName("Cardiology");
		cardiology.setLocation("Block A");
		cardiology.setHeadDoctorName("Dr. Mohan");

		Department neurology = new Department();
		neurology.setName("Neurology");
		neurology.setLocation("Block B");
		neurology.setHeadDoctorName("Dr. Rohit");

		Doctor d1 = new Doctor();
		d1.setName("Dr. Harish");
		d1.setSpecialization("Cardiology");
		d1.setLicenseNo("LIC001");

		Doctor d2 = new Doctor();
		d2.setName("Dr. Jeevan");
		d2.setSpecialization("Cardiology");
		d2.setLicenseNo("LIC002");

		Doctor d3 = new Doctor();
		d3.setName("Dr. Murari");
		d3.setSpecialization("neurology");
		d3.setLicenseNo("LIC003");

		Doctor d4 = new Doctor();
		d4.setName("Dr. Abhi");
		d4.setSpecialization("Neurology");
		d4.setLicenseNo("LIC004");

		cardiology.addDoctor(d1);
		cardiology.addDoctor(d2);

		neurology.addDoctor(d3);
		neurology.addDoctor(d4);

		em.persist(cardiology);
		em.persist(neurology);

		et.commit();
		em.close();

		
	}

	static void navigateBothWays() {
		EntityManager em = emf.createEntityManager();

		Department dept = em.find(Department.class, 1L);
		System.out.println("doctors in " + dept.getName() + ":");
		for (Doctor d : dept.getDoctors()) {
			System.out.println(d.getName());
		}

		Doctor doc = em.find(Doctor.class, 1L);
		System.out.println(doc.getName() + " in " + doc.getDepartment().getName());

		em.close();
	}

	static void transferDoctor() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Doctor d1 = em.find(Doctor.class, 1L);
		Department cardiology = d1.getDepartment();
		Department neurology = em.find(Department.class, 2L);

		cardiology.removeDoctor(d1);
		neurology.addDoctor(d1);

		et.commit();
		em.close();

		
	}

	static void jpqlQuery() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Doctor> query = em.createQuery(
			"SELECT d FROM Doctor d WHERE d.department.name = :dname", Doctor.class);
		query.setParameter("dname", "Cardiology");

		List<Doctor> doctors = query.getResultList();
		System.out.println("carodiology doctors:");
		for (Doctor d : doctors) {
			System.out.println(d.getName());
		}

		em.close();
	}

}
