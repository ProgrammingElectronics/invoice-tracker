package com.invoicetracker;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.CustomerImp;
import com.invoicetracker.models.InvoiceImp;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.CustomerImpRepository;
import com.invoicetracker.repositories.InvoiceImpRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@Component
public class Populator implements CommandLineRunner {

	@Resource
	ServiceItemRepository serviceItemRepo;
	
	@Resource
	CustomerImpRepository customerRepo;

	@Resource
	InvoiceImpRepository invoiceRepo;

	@Resource
	ContractorRepository contractorRepo;

	@Override
	public void run(String... args) throws Exception {
		
		
		/******************* Invoice Inv2 **********************/
		
		CustomerImp customerOneInv1 = new CustomerImp("Harry");
		CustomerImp customerTwoInv1 = new CustomerImp("Jill");
		customerRepo.save(customerTwoInv1);
		customerRepo.save(customerOneInv1);
		
		
		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1, customerOneInv1);
		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1, customerTwoInv1);
		serviceItemRepo.save(serviceItemOneInv1);
		serviceItemRepo.save(serviceItemTwoInv1);
		
		
		LocalDate dateThreeInv1 = LocalDate.of(2020, 4, 03);
		InvoiceImp invoiceOneInv1 = new InvoiceImp(dateThreeInv1, serviceItemOneInv1, serviceItemTwoInv1);
		invoiceRepo.save(invoiceOneInv1);
		
		/******************* Invoice Inv2 **********************/
		
		CustomerImp customerOneInv2 = new CustomerImp("Harry");
		CustomerImp customerTwoInv2 = new CustomerImp("Jill");
		customerRepo.save(customerTwoInv2);
		customerRepo.save(customerOneInv2);
		
		LocalDate dateOneInv2 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv2 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv2 = new ServiceItem(dateOneInv2, customerOneInv2);
		ServiceItem serviceItemTwoInv2 = new ServiceItem(dateTwoInv2, customerTwoInv2);
		serviceItemRepo.save(serviceItemOneInv2);
		serviceItemRepo.save(serviceItemTwoInv2);
		
		LocalDate dateThreeInv2 = LocalDate.of(2020, 4, 03);
		InvoiceImp invoiceOneInv2 = new InvoiceImp(dateThreeInv2, serviceItemOneInv2, serviceItemTwoInv2);
		invoiceRepo.save(invoiceOneInv2);
		
		//ContractorOne
		Contractor contractor = new Contractor("Emily", invoiceOneInv1, invoiceOneInv2);
		contractorRepo.save(contractor);
		
				
	}

	
	
}
