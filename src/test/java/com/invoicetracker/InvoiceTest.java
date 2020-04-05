package com.invoicetracker;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.invoicetracker.models.Customer;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.CustomerRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@DataJpaTest
class InvoiceTest {

	@Resource
	CustomerRepository customerRepo;

	@Resource
	ServiceItemRepository serviceItemRepo;

	@Resource
	InvoiceRepository invoiceRepo;
	
	@Test
	void shouldSumServiceItemsAmountDue() {
		
		Customer customerOneInv1 = new Customer("Harry");
		Customer customerTwoInv1 = new Customer("Jill");
		customerRepo.save(customerOneInv1);				
		customerRepo.save(customerTwoInv1);
		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1, customerOneInv1);
		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1, customerTwoInv1);
		serviceItemOneInv1.setAmountDue(300);
		serviceItemTwoInv1.setAmountDue(400);
		serviceItemRepo.save(serviceItemOneInv1);
		serviceItemRepo.save(serviceItemTwoInv1);
	
		LocalDate dateThreeInv1 = LocalDate.of(2020, 4, 03);
		Invoice invoiceOneInv1 = new Invoice(dateThreeInv1, serviceItemOneInv1, serviceItemTwoInv1);
		invoiceRepo.save(invoiceOneInv1);
		
		
		float result = invoiceOneInv1.getTotalAmountDue();
		
		assertEquals(700, result, 0.01);
	}
	
	@Test
	void shouldAddServiceItem() {
		Customer customerOneInv1 = new Customer("Harry");
		Customer customerTwoInv1 = new Customer("Jill");
		customerRepo.save(customerOneInv1);				
		customerRepo.save(customerTwoInv1);
		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1, customerOneInv1);
		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1, customerTwoInv1);
		serviceItemRepo.save(serviceItemOneInv1);
		serviceItemRepo.save(serviceItemTwoInv1);
		serviceItemOneInv1.setAmountDue(300);
		serviceItemTwoInv1.setAmountDue(400);
	
		LocalDate dateThreeInv1 = LocalDate.of(2020, 4, 03);
		Invoice invoiceOneInv1 = new Invoice(dateThreeInv1, serviceItemOneInv1);
		invoiceRepo.save(invoiceOneInv1);
		invoiceOneInv1.addServiceItem(serviceItemTwoInv1);
		
		int result = invoiceOneInv1.getServiceItems().size();
		
		assertEquals(2, result);
	}
}
