package main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Appointment;
import entity.Prescription;

public class CRUDTest4 {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public static void main(String[] args) {

		saveAppointmentWithPrescription();
		saveAppointmentWithoutPrescription();
		readBothAppointments();
	}

	static void saveAppointmentWithPrescription() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Prescription rx = new Prescription();
		rx.setMedicines("paracetamol , vitamin C");
		rx.setDosage("1 tablet twice daily");
		rx.setIssuedDate(LocalDate.now());
		rx.setActive(true);

		Appointment appt = new Appointment();
		appt.setAppointDate(LocalDateTime.of(2025, 4, 1, 10, 0));
		appt.setStatus("COMPLETED");
		appt.setReason("cold and cough");
		appt.setPrescription(rx);

		em.persist(appt);

		et.commit();
		em.close();

	}

	static void saveAppointmentWithoutPrescription() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Appointment appt = new Appointment();
		appt.setAppointDate(LocalDateTime.of(2025, 4, 2, 15, 0));
		appt.setStatus("SCHEDULED");
		appt.setReason("annual health checkup");
		appt.setPrescription(null);

		em.persist(appt);

		et.commit();
		em.close();

	}

	static void readBothAppointments() {
		EntityManager em = emf.createEntityManager();

		Appointment appt1 = em.find(Appointment.class, 1L);
		System.out.println("appointment 1 - reason: " + appt1.getReason());
		if (appt1.getPrescription() != null) {
			System.out.println("  prescription: " + appt1.getPrescription().getMedicines());
			System.out.println("  dosage: " + appt1.getPrescription().getDosage());
			System.out.println("  active: " + appt1.getPrescription().isActive());
		} else {
			System.out.println("n o prescription for this appointment");
		}

		Appointment appt2 = em.find(Appointment.class, 2L);
		System.out.println("appointment 2 - Reason: " + appt2.getReason());
		if (appt2.getPrescription() != null) {
			System.out.println(" perescription: " + appt2.getPrescription().getMedicines());
		} else {
			System.out.println("no prescription for this appointment.");
		}

		em.close();
	}

}
