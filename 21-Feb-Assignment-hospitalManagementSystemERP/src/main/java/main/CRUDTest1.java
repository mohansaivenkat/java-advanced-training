package main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.MedicalRecord;
import entity.Patient;

public class CRUDTest1 {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public static void main(String[] args) {

		createPatientWithRecord();
		readPatient();
		updateNotes();
		deletePatient();
	}

	public static void createPatientWithRecord() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		MedicalRecord record = new MedicalRecord();
		record.setRecordDate(LocalDate.now());
		record.setDiagnosis("Flu");
		record.setNotes("Rest 3 days");

		Patient patient = new Patient();
		patient.setName("Arjun");
		patient.setDob(LocalDate.of(1995, 6, 15));
		patient.setBloodGroup("O+");
		patient.setPhone("9876543210");
		patient.setMedicalRecord(record);

		em.persist(patient);

		et.commit();
		em.close();

		System.out.println("Patient saved with MedicalRecord.");
	}

	public static void readPatient() {
		EntityManager em = emf.createEntityManager();

		Patient patient = em.find(Patient.class, 1L);

		System.out.println("patient Name: " + patient.getName());
		System.out.println("dioagnosis: " + patient.getMedicalRecord().getDiagnosis());

		MedicalRecord record = em.find(MedicalRecord.class, patient.getMedicalRecord().getId());
		System.out.println("summary " + record.getSummary());
		

		em.close();
	}

	public static void updateNotes() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Patient patient = em.find(Patient.class, 1L);
		patient.getMedicalRecord().setNotes("update: follow-up");

		et.commit();
		em.close();

		
	}

	public static void deletePatient() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Patient patient = em.find(Patient.class, 1L);
		em.remove(patient);

		et.commit();
		em.close();

	}

}
