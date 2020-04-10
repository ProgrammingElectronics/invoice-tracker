package com.invoicetracker;

import java.time.LocalDate;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@Component
public class Populator implements CommandLineRunner {

	@Resource
	ServiceItemRepository serviceItemRepo;

	@Resource
	InvoiceRepository invoiceRepo;

	@Resource
	ContractorRepository contractorRepo;

	@Override
	public void run(String... args) throws Exception {
		
		/* Contractor_A has 2 invoices called invoice_A1 and invoice_A2
		 * invoice_A1 has 2 serviceItems, invoice_A2 has 3 serviceItems 
		 * */
			Contractor contractor_A = new Contractor();
			contractor_A.setEmail("contractor_A@gmail.com");
			contractor_A.setAddressLineOne("A St");
			contractor_A.setAddressLineTwo("Apt A");
			contractor_A.setCity("A city");
			contractor_A.setState("Alabama");
			contractor_A.setCountry("USA");
			contractor_A.setPhoneNumber("1-800-AAAAA");
			contractor_A.setFirstName("Andy");
			contractor_A.setLastName("Amoray");
			contractor_A.setPayPalId("AndyAmorayPayPal");
			contractorRepo.save(contractor_A);

			/********* invoice_A1 and service items *************/
			Invoice invoice_A1 = new Invoice(contractor_A);
			LocalDate dateInvoice_A1 = LocalDate.of(2020, 03, 28);
			invoice_A1.setDateOfInvoice(dateInvoice_A1);
			invoice_A1.setInvoiceNote("Contractor A's first Invoice");
			invoice_A1.setIsPaid(false);			
			invoiceRepo.save(invoice_A1);		
			
			ServiceItem serviceItem_A1 = new ServiceItem(invoice_A1);
			LocalDate dateServiceItem_A1 = LocalDate.of(2020, 03, 11);
			serviceItem_A1.setDateOfService(dateServiceItem_A1);
			serviceItem_A1.setAmountDue(100);
			serviceItem_A1.setServiceDescription("Tutored Alley");
			serviceItemRepo.save(serviceItem_A1);
			
			ServiceItem serviceItem_A2 = new ServiceItem(invoice_A1);
			LocalDate dateServiceItem_A2 = LocalDate.of(2020, 02, 01);
			serviceItem_A2.setDateOfService(dateServiceItem_A2);
			serviceItem_A2.setAmountDue(150);
			serviceItem_A2.setServiceDescription("Tutored Allen");
			serviceItemRepo.save(serviceItem_A2);

			/********* invoice_A2 and service items *************/
			
			Invoice invoice_A2 = new Invoice(contractor_A);
			LocalDate dateInvoice_A2 = LocalDate.of(2020, 03, 11);
			invoice_A2.setDateOfInvoice(dateInvoice_A2);
			invoice_A2.setInvoiceNote("Contractor A's second Invoice");
			invoice_A2.setIsPaid(false);
			invoiceRepo.save(invoice_A2);
			
			ServiceItem serviceItem_A3 = new ServiceItem(invoice_A2);
			LocalDate dateServiceItem_A3 = LocalDate.of(2020, 02, 12);
			serviceItem_A3.setDateOfService(dateServiceItem_A3);
			serviceItem_A3.setAmountDue(200);
			serviceItem_A3.setServiceDescription("Tutored Angel");
			serviceItemRepo.save(serviceItem_A3);
			
			ServiceItem serviceItem_A4 = new ServiceItem(invoice_A2);
			LocalDate dateServiceItem_A4 = LocalDate.of(2020, 02, 02);
			serviceItem_A4.setDateOfService(dateServiceItem_A4);
			serviceItem_A4.setAmountDue(250);
			serviceItem_A4.setServiceDescription("Tutored Amorilla");
			serviceItemRepo.save(serviceItem_A4);
			
			ServiceItem serviceItem_A5 = new ServiceItem(invoice_A2);
			LocalDate dateServiceItem_A5 = LocalDate.of(2020, 02, 01);
			serviceItem_A5.setDateOfService(dateServiceItem_A5);
			serviceItem_A5.setAmountDue(350);
			serviceItem_A5.setServiceDescription("Tutored Ack");
			serviceItemRepo.save(serviceItem_A5);
			
			
			contractorRepo.save(contractor_A);
	}
}