package main;

import java.util.Arrays;
import java.util.List;

import entity.Address;
import service.CustomerService;
import service.EmployeeService;
import service.LeadService;
import service.OrderService;
import service.ProductService;
import service.ReportService;
import service.TicketService;

public class Main {
    public static void main(String[] args) {
       
        CustomerService customerService = new CustomerService();
        LeadService leadService = new LeadService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        ReportService reportService = new ReportService();
        TicketService ticketService = new TicketService();
        EmployeeService employeeService = new EmployeeService();

        // Create a Sales Employee first (needed for lead assignment)
        employeeService.addEmployee("Rahul", "Sales");
        System.out.println("employee added.");

        
        customerService.registerCustomer("Mohan", "mohan@example.com", "9876543210");
        System.out.println("customer registered.");

        
        Address addr = new Address();
        addr.setCity("Mumbai");
        addr.setState("Maharashtra");
        addr.setPincode("400001");
        customerService.addAddressToCustomer(1L, addr);
        
        
        System.out.println("added address");

     
        leadService.createLead("Anjali", "LinkedIn", "anjali@work.com", "anjali.lead@test.com");
        System.out.println("lead created");

        leadService.assignLeadToEmployee(1L, 1L);
        System.out.println("lead assigned to employee");

        leadService.convertLeadToCustomer(1L);
        System.out.println("lead converted to customer");

    
        productService.addProduct("Laptop", 75000.0);
        productService.addProduct("Mouse", 1500.0);
        System.out.println("products added");

        List<Long> productIds = Arrays.asList(1L, 2L);
        orderService.placeOrder(1L, productIds);
        System.out.println("order placed.");

        ticketService.raiseTicket(1L, "Laptop screen flickering on arrival");
        System.out.println("support ticket raised.");

       
        System.out.println("generating performance report...");
        reportService.getEmployeePerformance(1L);

        System.out.println("exiting");
    }
}
