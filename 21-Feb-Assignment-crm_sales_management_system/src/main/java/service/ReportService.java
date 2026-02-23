package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.SalesEmployee;
import entity.Lead;
import java.util.List;

public class ReportService {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");

	public void getEmployeePerformance(Long employeeId) {
		EntityManager em = emf.createEntityManager();

		SalesEmployee employee = em.find(SalesEmployee.class, employeeId);

		List<Lead> leads = employee.getLeads();

		System.out.println("--- Performance Report for: " + employee.getName() + " ---");
		System.out.println("Department: " + employee.getDepartment());
		System.out.println("Total Leads Managed: " + (leads != null ? leads.size() : 0));

		if (leads != null && !leads.isEmpty()) {
			System.out.println("\nDetailed Lead Status:");
			for (Lead lead : leads) {

				System.out.println("- Lead Name: " + lead.getName() + " | Source: " + lead.getSource() + " | Status: "
						+ lead.getStatus());
			}
		} else {
			System.out.println("No leads currently assigned to this employee.");
		}

	}
}
