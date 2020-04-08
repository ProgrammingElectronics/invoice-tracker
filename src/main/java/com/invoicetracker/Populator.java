package com.invoicetracker;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.Customer;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.CustomerRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@Component
public class Populator implements CommandLineRunner {

	@Resource
	ServiceItemRepository serviceItemRepo;

	@Resource
	CustomerRepository customerRepo;

	@Resource
	InvoiceRepository invoiceRepo;

	@Resource
	ContractorRepository contractorRepo;

	@Override
	public void run(String... args) throws Exception {

		/*
		 *  TODO: This needs simplified. 
		 *  Maybe a constructor that accepts all this at once or something.
		 *  
		 *  It just feels absurd.
		 */
		
		/******************* Invoice Inv1 **********************/

		Customer customerOneInv1 = new Customer("Harry");
		Customer customerTwoInv1 = new Customer("Jill");
		customerRepo.save(customerTwoInv1);
		customerRepo.save(customerOneInv1);

		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1, customerOneInv1);
		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1, customerTwoInv1);
		ServiceItem serviceItemThreeInv1 = new ServiceItem(dateTwoInv1);
		serviceItemOneInv1.setAmountDue(300);
		serviceItemTwoInv1.setAmountDue(940);
		serviceItemThreeInv1.setAmountDue(120);
		serviceItemOneInv1.setCustomerName("Timmy");
		serviceItemTwoInv1.setCustomerName("Jose");
		serviceItemThreeInv1.setCustomerName("Jolinda");
		serviceItemRepo.save(serviceItemOneInv1);
		serviceItemRepo.save(serviceItemTwoInv1);
		serviceItemRepo.save(serviceItemThreeInv1);

		LocalDate dateThreeInv1 = LocalDate.of(2020, 4, 03);
		Invoice invoiceOneInv1 = new Invoice(dateThreeInv1, serviceItemOneInv1, serviceItemTwoInv1, serviceItemThreeInv1);
		invoiceOneInv1.setPaid(true);
		invoiceOneInv1.setInvoiceNumber(1001);
		invoiceRepo.save(invoiceOneInv1);

		/******************* Invoice Inv2 **********************/

		Customer customerOneInv2 = new Customer("Kerry");
		Customer customerTwoInv2 = new Customer("Hal");
		customerRepo.save(customerTwoInv2);
		customerRepo.save(customerOneInv2);

		LocalDate dateOneInv2 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv2 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv2 = new ServiceItem(dateOneInv2, customerOneInv2);
		ServiceItem serviceItemTwoInv2 = new ServiceItem(dateTwoInv2, customerTwoInv2);
		serviceItemOneInv2.setAmountDue(100);
		serviceItemTwoInv2.setAmountDue(550);
		serviceItemOneInv2.setCustomerName("Letisha");
		serviceItemTwoInv2.setCustomerName("Eleanor");
		serviceItemRepo.save(serviceItemOneInv2);
		serviceItemRepo.save(serviceItemTwoInv2);

		LocalDate dateThreeInv2 = LocalDate.of(2020, 4, 03);
		Invoice invoiceOneInv2 = new Invoice(dateThreeInv2, serviceItemOneInv2, serviceItemTwoInv2);
		invoiceOneInv2.setPaid(false);
		invoiceOneInv2.setInvoiceNumber(1002);
		invoiceRepo.save(invoiceOneInv2);

		/******************* Invoice Inv3 **********************/

		Customer customerOneInv3 = new Customer("luke");
		Customer customerTwoInv3 = new Customer("malley");
		customerRepo.save(customerTwoInv3);
		customerRepo.save(customerOneInv3);

		LocalDate dateOneInv3 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv3 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv3 = new ServiceItem(dateOneInv3, customerOneInv3);
		ServiceItem serviceItemTwoInv3 = new ServiceItem(dateTwoInv3, customerTwoInv3);
		serviceItemOneInv3.setAmountDue(100);
		serviceItemTwoInv3.setAmountDue(550);
		serviceItemOneInv3.setCustomerName("Tiera");
		serviceItemTwoInv3.setCustomerName("Maria");
		serviceItemRepo.save(serviceItemOneInv3);
		serviceItemRepo.save(serviceItemTwoInv3);

		LocalDate dateThreeInv3 = LocalDate.of(2020, 4, 03);
		Invoice invoiceOneInv3 = new Invoice(dateThreeInv3, serviceItemOneInv3, serviceItemTwoInv3);
		invoiceOneInv3.setPaid(false);
		invoiceOneInv3.setInvoiceNumber(1003);
		invoiceRepo.save(invoiceOneInv3);

		/******************* Invoice Inv4 **********************/
		
		Customer customerOneInv4 = new Customer("JoJo");
		Customer customerTwoInv4 = new Customer("Rocky");
		customerRepo.save(customerTwoInv4);
		customerRepo.save(customerOneInv4);
		
		LocalDate dateOneInv4 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv4 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv4 = new ServiceItem(dateOneInv4, customerOneInv4);
		ServiceItem serviceItemTwoInv4 = new ServiceItem(dateTwoInv4, customerTwoInv4);
		serviceItemOneInv4.setAmountDue(100);
		serviceItemTwoInv4.setAmountDue(550);
		serviceItemOneInv4.setCustomerName("Loulou");
		serviceItemTwoInv4.setCustomerName("Haley");
		serviceItemRepo.save(serviceItemOneInv4);
		serviceItemRepo.save(serviceItemTwoInv4);
		
		LocalDate dateThreeInv4 = LocalDate.of(2020, 4, 04);
		Invoice invoiceOneInv4 = new Invoice(dateThreeInv4, serviceItemOneInv4, serviceItemTwoInv4);
		invoiceOneInv4.setPaid(false);
		invoiceOneInv4.setInvoiceNumber(1004);
		invoiceRepo.save(invoiceOneInv4);
		
		/******************* Invoice Inv5 **********************/
		
		Customer customerOneInv5 = new Customer("JoJo");
		Customer customerTwoInv5 = new Customer("Rocky");
		customerRepo.save(customerTwoInv5);
		customerRepo.save(customerOneInv5);
		
		LocalDate dateOneInv5 = LocalDate.of(2020, 5, 01);
		LocalDate dateTwoInv5 = LocalDate.of(2020, 5, 02);
		ServiceItem serviceItemOneInv5 = new ServiceItem(dateOneInv5, customerOneInv5);
		ServiceItem serviceItemTwoInv5 = new ServiceItem(dateTwoInv5, customerTwoInv5);
		serviceItemOneInv5.setAmountDue(100);
		serviceItemTwoInv5.setAmountDue(550);
		serviceItemOneInv5.setCustomerName("Jojo");
		serviceItemTwoInv5.setCustomerName("Rocky");
		serviceItemRepo.save(serviceItemOneInv5);
		serviceItemRepo.save(serviceItemTwoInv5);
		
		LocalDate dateThreeInv5 = LocalDate.of(2020, 5, 05);
		Invoice invoiceOneInv5 = new Invoice(dateThreeInv5, serviceItemOneInv5, serviceItemTwoInv5);
		invoiceOneInv5.setPaid(false);
		invoiceOneInv5.setInvoiceNumber(1005);
		invoiceRepo.save(invoiceOneInv5);

		// ContractorOne
		Contractor contractor = new Contractor("Emily", invoiceOneInv1, invoiceOneInv2, invoiceOneInv3, invoiceOneInv4, invoiceOneInv5);
		contractorRepo.save(contractor);
		contractor.setEmail("em@projo.com");

	}

}
