package main;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Doctor;
import entity.Patient;

public class CRUDTest5 {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public static void main(String[] args) {

		persistTreatmentAssignments();
		queryPatientsOfDoctor();
		dischargePatientFromDoctor();
		lazyInitializationFix();
	}

	public static void persistTreatmentAssignments() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Doctor d1 = new Doctor();
		d1.setName("Dr.Mohan");
		d1.setSpecialization("Cardiology");
		d1.setLicenseNo("LIC020");

		Doctor d2 = new Doctor();
		d2.setName("Dr.Harish");
		d2.setSpecialization("Neurology");
		d2.setLicenseNo("LIC021");

		Patient p1 = new Patient();
		p1.setName("Ali");
		p1.setDob(LocalDate.of(1990, 1, 15));
		p1.setBloodGroup("A+");
		p1.setPhone("9000000001");

		Patient p2 = new Patient();
		p2.setName("Priya");
		p2.setDob(LocalDate.of(1988, 5, 20));
		p2.setBloodGroup("B+");
		p2.setPhone("9000000002");

		Patient p3 = new Patient();
		p3.setName("Raj");
		p3.setDob(LocalDate.of(1992, 3, 10));
		p3.setBloodGroup("O-");
		p3.setPhone("9000000003");

		d1.addPatient(p1);
		d2.addPatient(p2);
		d2.addPatient(p1);
		d2.addPatient(p3);

		em.persist(d1);
		em.persist(d2);

		et.commit();
		em.close();

	}

	static void queryPatientsOfDoctor() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Doctor> query = em.createQuery(
			"SELECT d FROM Doctor d JOIN FETCH d.patients WHERE d.name = :n", Doctor.class);
		query.setParameter("n", "Dr.Mohan");

		Doctor drMehta = query.getSingleResult();
		System.out.println("patients of Dr.Mohan:");
		for (Patient p : drMehta.getPatients()) {
			System.out.println("  -> " + p.getName());
		}

		TypedQuery<Patient> reverseQuery = em.createQuery(
			"SELECT p FROM Patient p JOIN FETCH p.doctors WHERE p.name = :name", Patient.class);
		reverseQuery.setParameter("name", "Ali");

		Patient ali = reverseQuery.getSingleResult();
		System.out.println("doctors treating Ali:");
		for (Doctor d : ali.getDoctors()) {
			System.out.println(d.getName());
		}

		em.close();
	}

	static void dischargePatientFromDoctor() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		TypedQuery<Doctor> dq = em.createQuery(
			"SELECT d FROM Doctor d JOIN FETCH d.patients WHERE d.name = :n", Doctor.class);
		dq.setParameter("n", "Dr.Mohan");
		Doctor drMehta = dq.getSingleResult();

		TypedQuery<Patient> pq = em.createQuery(
			"SELECT p FROM Patient p WHERE p.name = :name", Patient.class);
		pq.setParameter("name", "Ali");
		Patient ali = pq.getSingleResult();

		drMehta.removePatient(ali);

		et.commit();
		em.close();

	}

	static void lazyInitializationFix() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Doctor> query = em.createQuery(
			"SELECT d FROM Doctor d JOIN FETCH d.patients WHERE d.name = :n", Doctor.class);
		query.setParameter("n", "Dr.Harish");

		Doctor drSingh = query.getSingleResult();
		em.close();

		System.out.println("Patients of Dr.Harish:");
		for (Patient p : drSingh.getPatients()) {
			System.out.println("  -> " + p.getName());
		}
	}

}
