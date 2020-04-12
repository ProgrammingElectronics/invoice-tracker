package com.invoicetracker;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
class ServiceItemTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	ContractorRepository contractorRepo;

	@Resource
	ServiceItemRepository serviceItemRepo;

	@Resource
	InvoiceRepository invoiceRepo;

	@Test
	void shouldFormatAmountDueAsCurrency() {
		//Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		ServiceItem serviceItem = serviceItemRepo.save(new ServiceItem(invoice));
		serviceItem.setAmountDue(300);
		long serviceItemId = serviceItem.getId();
		// Act
		entityManager.flush();
		entityManager.clear();
		ServiceItem result = serviceItemRepo.findById(serviceItemId).get();		
		
		assertEquals("$300.00", result.getAmountDueAsCurrencyString());
	}

}
