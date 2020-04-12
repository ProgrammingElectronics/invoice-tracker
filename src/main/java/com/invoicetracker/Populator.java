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

		/*
		 * Contractor_A has 5 invoices called invoice_A1...A5 each invoice has 1 to 4
		 * service items
		 */
		Contractor contractor_A = new Contractor();
		contractor_A.setEmail("JohnSmith@gmail.com");
		contractor_A.setAddressLineOne("Center St");
		contractor_A.setAddressLineTwo("Suite A");
		contractor_A.setCity("Cityville");
		contractor_A.setState("Alabama");
		contractor_A.setZip("90210");
		contractor_A.setCountry("USA");
		contractor_A.setPhoneNumber("(555) 555-5555");
		contractor_A.setFirstName("Andy");
		contractor_A.setLastName("Amoray");
		contractor_A.setPayPalId("AndyAmorayPayPal");
		contractorRepo.save(contractor_A);

		/********* Next invoice and service items *************/
		{
			Invoice invoice_A1 = new Invoice(contractor_A);
			LocalDate dateInvoice_A1 = LocalDate.of(2020, 03, 28);
			invoice_A1.setDateOfInvoice(dateInvoice_A1);
			invoice_A1.setInvoiceNote("Students did a great job applying themselves durring both sessions, I am very impressed with the progress!");
			invoice_A1.setIsPaid(false);
			invoiceRepo.save(invoice_A1);
			contractorRepo.save(contractor_A);

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
		}
		/********* Next invoice and service items *************/
		{
			Invoice invoice_A2 = new Invoice(contractor_A);
			LocalDate dateInvoice_A2 = LocalDate.of(2020, 03, 11);
			invoice_A2.setDateOfInvoice(dateInvoice_A2);
			invoice_A2.setInvoiceNote("Students did a great job applying themselves durring both sessions, I am very impressed with the progress!");
			invoice_A2.setIsPaid(false);
			invoiceRepo.save(invoice_A2);

			ServiceItem serviceItem_A3 = new ServiceItem(invoice_A2);
			LocalDate dateServiceItem_A3 = LocalDate.of(2020, 02, 12);
			serviceItem_A3.setDateOfService(dateServiceItem_A3);
			serviceItem_A3.setAmountDue(200);
			serviceItem_A3.setServiceDescription("Tutored Billy");
			serviceItemRepo.save(serviceItem_A3);

			ServiceItem serviceItem_A4 = new ServiceItem(invoice_A2);
			LocalDate dateServiceItem_A4 = LocalDate.of(2020, 02, 02);
			serviceItem_A4.setDateOfService(dateServiceItem_A4);
			serviceItem_A4.setAmountDue(250);
			serviceItem_A4.setServiceDescription("Tutored Bobo");
			serviceItemRepo.save(serviceItem_A4);

			ServiceItem serviceItem_A5 = new ServiceItem(invoice_A2);
			LocalDate dateServiceItem_A5 = LocalDate.of(2020, 02, 01);
			serviceItem_A5.setDateOfService(dateServiceItem_A5);
			serviceItem_A5.setAmountDue(350);
			serviceItem_A5.setServiceDescription("Tutored Bathsheba");
			serviceItemRepo.save(serviceItem_A5);
		}
		/********* Next invoice and service items *************/
		{
			Invoice invoice_A3 = new Invoice(contractor_A);
			LocalDate dateInvoice_A3 = LocalDate.of(2020, 03, 11);
			invoice_A3.setDateOfInvoice(dateInvoice_A3);
			invoice_A3.setInvoiceNote("Contractor A's Third Invoice");
			invoice_A3.setIsPaid(false);
			invoiceRepo.save(invoice_A3);

			ServiceItem serviceItem_A6 = new ServiceItem(invoice_A3);
			LocalDate dateServiceItem_A6 = LocalDate.of(2020, 02, 12);
			serviceItem_A6.setDateOfService(dateServiceItem_A6);
			serviceItem_A6.setAmountDue(200);
			serviceItem_A6.setServiceDescription("Tutored Chanel");
			serviceItemRepo.save(serviceItem_A6);

			ServiceItem serviceItem_A7 = new ServiceItem(invoice_A3);
			LocalDate dateServiceItem_A7 = LocalDate.of(2020, 02, 02);
			serviceItem_A7.setDateOfService(dateServiceItem_A7);
			serviceItem_A7.setAmountDue(250);
			serviceItem_A7.setServiceDescription("Tutored Chira");
			serviceItemRepo.save(serviceItem_A7);

			ServiceItem serviceItem_A8 = new ServiceItem(invoice_A3);
			LocalDate dateServiceItem_A8 = LocalDate.of(2020, 02, 01);
			serviceItem_A8.setDateOfService(dateServiceItem_A8);
			serviceItem_A8.setAmountDue(350);
			serviceItem_A8.setServiceDescription("Tutored Carton'O");
			serviceItemRepo.save(serviceItem_A8);
		}
		/********* Next invoice and service items *************/
		{
			Invoice invoice_A4 = new Invoice(contractor_A);
			LocalDate dateInvoice_A4 = LocalDate.of(2020, 03, 11);
			invoice_A4.setDateOfInvoice(dateInvoice_A4);
			invoice_A4.setInvoiceNote("Contractor A's Fourth Invoice");
			invoice_A4.setIsPaid(false);
			invoiceRepo.save(invoice_A4);

			ServiceItem serviceItem_A9 = new ServiceItem(invoice_A4);
			LocalDate dateServiceItem_A9 = LocalDate.of(2020, 02, 12);
			serviceItem_A9.setDateOfService(dateServiceItem_A9);
			serviceItem_A9.setAmountDue(200);
			serviceItem_A9.setServiceDescription("Tutored David");
			serviceItemRepo.save(serviceItem_A9);

			ServiceItem serviceItem_A10 = new ServiceItem(invoice_A4);
			LocalDate dateServiceItem_A10 = LocalDate.of(2020, 02, 02);
			serviceItem_A10.setDateOfService(dateServiceItem_A10);
			serviceItem_A10.setAmountDue(250);
			serviceItem_A10.setServiceDescription("Tutored Donna");
			serviceItemRepo.save(serviceItem_A10);

			ServiceItem serviceItem_A11 = new ServiceItem(invoice_A4);
			LocalDate dateServiceItem_A11 = LocalDate.of(2020, 02, 01);
			serviceItem_A11.setDateOfService(dateServiceItem_A11);
			serviceItem_A11.setAmountDue(350);
			serviceItem_A11.setServiceDescription("Tutored Dauphny");
			serviceItemRepo.save(serviceItem_A11);

			ServiceItem serviceItem_A12 = new ServiceItem(invoice_A4);
			LocalDate dateServiceItem_A12 = LocalDate.of(2020, 02, 01);
			serviceItem_A12.setDateOfService(dateServiceItem_A12);
			serviceItem_A12.setAmountDue(350);
			serviceItem_A12.setServiceDescription("Tutored Le'Don");
			serviceItemRepo.save(serviceItem_A12);
		}
		/********* Next invoice and service items *************/
		{
			Invoice invoice_A5 = new Invoice(contractor_A);
			LocalDate dateInvoice_A5 = LocalDate.of(2020, 01, 11);
			invoice_A5.setDateOfInvoice(dateInvoice_A5);
			invoice_A5.setInvoiceNote("Contractor A's Fith Invoice");
			invoice_A5.setIsPaid(false);
			invoiceRepo.save(invoice_A5);

			ServiceItem serviceItem_A13 = new ServiceItem(invoice_A5);
			LocalDate dateServiceItem_A13 = LocalDate.of(2020, 02, 12);
			serviceItem_A13.setDateOfService(dateServiceItem_A13);
			serviceItem_A13.setAmountDue(200);
			serviceItem_A13.setServiceDescription("Tutored Erin");
			serviceItemRepo.save(serviceItem_A13);
		}
	}
}