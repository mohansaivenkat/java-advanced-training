package main;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Appointment;
import entity.Department;
import entity.Doctor;

public class CRUDTest3 {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public static void main(String[] args) {

		saveDoctorWithAppointments();
		navigationLimitation();
		updateAppointmentStatus();
	}

	public static void saveDoctorWithAppointments() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Department dept = new Department();
		dept.setName("General");
		dept.setLocation("Block C");
		dept.setHeadDoctorName("Dr.Harish");
		em.persist(dept);

		Doctor doctor = new Doctor();
		doctor.setName("Dr. reha");
		doctor.setSpecialization("General Medicine");
		doctor.setLicenseNo("LIC010");
		doctor.setDepartment(dept);

		Appointment appt1 = new Appointment();
		appt1.setAppointDate(LocalDateTime.of(2025, 3, 10, 9, 0));
		appt1.setStatus("SCHEDULED");
		appt1.setReason("fever and headache");

		Appointment appt2 = new Appointment();
		appt2.setAppointDate(LocalDateTime.of(2025, 3, 11, 11, 0));
		appt2.setStatus("COMPLETED");
		appt2.setReason("follow up checkup");

		Appointment appt3 = new Appointment();
		appt3.setAppointDate(LocalDateTime.of(2025, 3, 12, 14, 0));
		appt3.setStatus("CANCELLED");
		appt3.setReason("patient not available");

		doctor.getAppointments().add(appt1);
		doctor.getAppointments().add(appt2);
		doctor.getAppointments().add(appt3);

		em.persist(doctor);

		et.commit();
		em.close();

		
	}

	public static void navigationLimitation() {
		EntityManager em = emf.createEntityManager();

		Appointment appt = em.find(Appointment.class, 1L);
		System.out.println("appointment staus" + appt.getStatus());

		em.close();
	}

	public static void updateAppointmentStatus() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Doctor doctor = em.find(Doctor.class, 1L);
		List<Appointment> appointments = doctor.getAppointments();

		for (Appointment appt : appointments) {
			if (appt.getStatus().equals("SCHEDULED")) {
				appt.setStatus("COMPLETED");
				System.out.println("appointment id=" + appt.getId() + " updated to COMPLETED");
			}
		}

		et.commit();
		em.close();

	
	}

}
