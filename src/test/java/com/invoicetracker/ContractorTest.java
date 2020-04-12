package com.invoicetracker;

import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.InvoiceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
class ContractorTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	ContractorRepository contractorRepo;

	@Resource
	InvoiceRepository invoiceRepo;
	
	@Test
	void shouldAdd1TocurrentInvoiceNumber() {
		//Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		@SuppressWarnings("unused")
		Invoice invoiceOne = invoiceRepo.save(new Invoice(contractor));
		@SuppressWarnings("unused")
		Invoice invoiceTwo = invoiceRepo.save(new Invoice(contractor));
		contractorRepo.save(contractor);
		long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		int result = contractorRepo.findById(contractorId).get().getCurrentInvoiceNumber();

		assertEquals(1002, result);
	}

}
