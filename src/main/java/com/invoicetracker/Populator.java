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
		contractor_A.setEmail("JamesHolden@gmail.com");
		contractor_A.setAddressLineOne("2303 Rocinante Ave");
		contractor_A.setAddressLineTwo("Suite A");
		contractor_A.setCity("Tycho");
		contractor_A.setState("Alabama");
		contractor_A.setZip("90210");
		contractor_A.setCountry("USA");
		contractor_A.setPhoneNumber("(501) 532-5111");
		contractor_A.setFirstName("James");
		contractor_A.setLastName("Holden");
		contractor_A.setPayPalId("PlumberGuyPayPal");
		contractorRepo.save(contractor_A);

		/********* Next invoice and service items *************/
		{
			Invoice invoice_A1 = new Invoice(contractor_A);
			LocalDate dateInvoice_A1 = LocalDate.of(2020, 04, 16);
			invoice_A1.setDateOfInvoice(dateInvoice_A1);
			invoice_A1.setInvoiceNote(
					"Parts were billed at cost.  Please pay total within 30 days");
			invoice_A1.setIsPaid(false);
			invoiceRepo.save(invoice_A1);
			contractorRepo.save(contractor_A);

			ServiceItem serviceItem_A1 = new ServiceItem(invoice_A1);
			LocalDate dateServiceItem_A1 = LocalDate.of(2020, 04, 15);
			serviceItem_A1.setDateOfService(dateServiceItem_A1);
			serviceItem_A1.setAmountDue(150);
			serviceItem_A1.setServiceDescription("Replaced disposal");
			serviceItemRepo.save(serviceItem_A1);

			ServiceItem serviceItem_A2 = new ServiceItem(invoice_A1);
			LocalDate dateServiceItem_A2 = LocalDate.of(2020, 04, 15);
			serviceItem_A2.setDateOfService(dateServiceItem_A2);
			serviceItem_A2.setAmountDue(350);
			serviceItem_A2.setServiceDescription("New disposal unit cost");
			serviceItemRepo.save(serviceItem_A2);
		}
		/********* Next invoice and service items *************/
		{
			Invoice invoice_A2 = new Invoice(contractor_A);
			LocalDate dateInvoice_A2 = LocalDate.of(2020, 04, 04);
			invoice_A2.setDateOfInvoice(dateInvoice_A2);
			invoice_A2.setInvoiceNote(
					"Please Pay in cash or check within 30 days.");
			invoice_A2.setIsPaid(false);
			invoiceRepo.save(invoice_A2);

			ServiceItem serviceItem_A3 = new ServiceItem(invoice_A2);
			LocalDate dateServiceItem_A3 = LocalDate.of(2020, 04, 03);
			serviceItem_A3.setDateOfService(dateServiceItem_A3);
			serviceItem_A3.setAmountDue(200);
			serviceItem_A3.setServiceDescription("Fixed shower drain flow");
			serviceItemRepo.save(serviceItem_A3);

			ServiceItem serviceItem_A4 = new ServiceItem(invoice_A2);
			LocalDate dateServiceItem_A4 = LocalDate.of(2020, 04, 03);
			serviceItem_A4.setDateOfService(dateServiceItem_A4);
			serviceItem_A4.setAmountDue(250);
			serviceItem_A4.setServiceDescription("Replaced toilet 1st floor bathroom");
			serviceItemRepo.save(serviceItem_A4);

			ServiceItem serviceItem_A5 = new ServiceItem(invoice_A2);
			LocalDate dateServiceItem_A5 = LocalDate.of(2020, 04, 03);
			serviceItem_A5.setDateOfService(dateServiceItem_A5);
			serviceItem_A5.setAmountDue(350);
			serviceItem_A5.setServiceDescription("Fixed leaky kitchen sink");
			serviceItemRepo.save(serviceItem_A5);
		}
		/********* Next invoice and service items *************/
		{
			Invoice invoice_A3 = new Invoice(contractor_A);
			LocalDate dateInvoice_A3 = LocalDate.of(2020, 03, 25);
			invoice_A3.setDateOfInvoice(dateInvoice_A3);
			invoice_A3.setInvoiceNote("If you would like more work done, please reach out.");
			invoice_A3.setIsPaid(false);
			invoiceRepo.save(invoice_A3);

			ServiceItem serviceItem_A6 = new ServiceItem(invoice_A3);
			LocalDate dateServiceItem_A6 = LocalDate.of(2020, 03, 24);
			serviceItem_A6.setDateOfService(dateServiceItem_A6);
			serviceItem_A6.setAmountDue(200);
			serviceItem_A6.setServiceDescription("1st floor bathroom faucent replaced");
			serviceItemRepo.save(serviceItem_A6);

			ServiceItem serviceItem_A7 = new ServiceItem(invoice_A3);
			LocalDate dateServiceItem_A7 = LocalDate.of(2020, 03, 22);
			serviceItem_A7.setDateOfService(dateServiceItem_A7);
			serviceItem_A7.setAmountDue(150);
			serviceItem_A7.setServiceDescription("New Moen faucet - parts");
			serviceItemRepo.save(serviceItem_A7);

		}
		/********* Next invoice and service items *************/
		{
			Invoice invoice_A4 = new Invoice(contractor_A);
			LocalDate dateInvoice_A4 = LocalDate.of(2020, 03, 11);
			invoice_A4.setDateOfInvoice(dateInvoice_A4);
			invoice_A4.setInvoiceNote("Please pay in full with in 30 days, cash or check");
			invoice_A4.setIsPaid(false);
			invoiceRepo.save(invoice_A4);

			ServiceItem serviceItem_A9 = new ServiceItem(invoice_A4);
			LocalDate dateServiceItem_A9 = LocalDate.of(2020, 03, 10);
			serviceItem_A9.setDateOfService(dateServiceItem_A9);
			serviceItem_A9.setAmountDue(125);
			serviceItem_A9.setServiceDescription("Installed washer drain/ supply lines");
			serviceItemRepo.save(serviceItem_A9);

			ServiceItem serviceItem_A10 = new ServiceItem(invoice_A4);
			LocalDate dateServiceItem_A10 = LocalDate.of(2020, 03, 10);
			serviceItem_A10.setDateOfService(dateServiceItem_A10);
			serviceItem_A10.setAmountDue(50);
			serviceItem_A10.setServiceDescription("Washer line parts kit");
			serviceItemRepo.save(serviceItem_A10);

			
		}
		/********* Next invoice and service items *************/
		{
			Invoice invoice_A5 = new Invoice(contractor_A);
			LocalDate dateInvoice_A5 = LocalDate.of(2020, 03, 5);
			invoice_A5.setDateOfInvoice(dateInvoice_A5);
			invoice_A5.setInvoiceNote("Please pay in full within 30 days, cash or check.  Next time, don't try to put chicken bones through the disposal.");
			invoice_A5.setIsPaid(false);
			invoiceRepo.save(invoice_A5);

			ServiceItem serviceItem_A13 = new ServiceItem(invoice_A5);
			LocalDate dateServiceItem_A13 = LocalDate.of(2020, 03, 5);
			serviceItem_A13.setDateOfService(dateServiceItem_A13);
			serviceItem_A13.setAmountDue(200);
			serviceItem_A13.setServiceDescription("Unclogged kitchen drain");
			serviceItemRepo.save(serviceItem_A13);
		}
	}
}