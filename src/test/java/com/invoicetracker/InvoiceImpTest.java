package com.invoicetracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.invoicetracker.models.CustomerImp;
import com.invoicetracker.models.InvoiceImp;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.CustomerImpRepository;
import com.invoicetracker.repositories.InvoiceImpRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@DataJpaTest
class InvoiceImpTest {

	@Resource
	CustomerImpRepository customerRepo;

	@Resource
	ServiceItemRepository serviceItemRepo;

	@Resource
	InvoiceImpRepository invoiceRepo;
	
	@Test
	void shouldSumServiceItemsAmountDue() {
		
		CustomerImp customerOneInv1 = new CustomerImp("Harry");
		CustomerImp customerTwoInv1 = new CustomerImp("Jill");
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
		InvoiceImp invoiceOneInv1 = new InvoiceImp(dateThreeInv1, serviceItemOneInv1, serviceItemTwoInv1);
		invoiceRepo.save(invoiceOneInv1);
		
		
		float result = invoiceOneInv1.getTotalAmountDue();
		
		assertEquals(700, result, 0.01);
	}
	

}
