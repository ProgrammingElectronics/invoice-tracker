package com.invoicetracker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.time.LocalDate;
import java.util.Optional;
import javax.annotation.Resource;
import org.junit.Test;
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
public class JPAMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ContractorRepository contractorRepo;

	@Resource
	private InvoiceRepository invoiceRepo;

	@Resource
	private ServiceItemRepository serviceItemRepo;

	@Test
	public void shouldSaveAndLoadContractorPayPalId() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor("firstName"));
		contractor.setPayPalId("payPalId");
		long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();

		assertEquals(contractor.getPayPalId(), "payPalId");

	}

	@Test
	public void shouldSaveAndLoadContractorFirstName() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor("firstName"));
		long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();

		assertEquals(contractor.getFirstName(), "firstName");
	}

	@Test
	public void shouldGenrateContractorId() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor("firstName"));
		long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();

		assertThat(contractor.getId(), is(greaterThan(0L)));
	}

	
	@Test
	public void shouldSaveAndLoadInvoiceDateOfService() {
		// Arrange
	    Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		LocalDate date = LocalDate.of(2020, 03, 28);
		invoice.setDateOfInvoice(date);
		Long invoiceId = invoice.getId();
		
		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<Invoice> result = invoiceRepo.findById(invoiceId);
		invoice = result.get();

		assertEquals(invoice.getDateOfInvoice(), date);
	}

	@Test
	public void shouldGenerateInvoiceId() {
		// Arrange
	    Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		Long invoiceId = invoice.getId();
		
		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<Invoice> result = invoiceRepo.findById(invoiceId);
		invoice = result.get();

		assertThat(invoice.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldGenerateServiceItemId() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		ServiceItem serviceItem = serviceItemRepo.save(new ServiceItem(invoice));
		long serviceItemId = serviceItem.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<ServiceItem> result = serviceItemRepo.findById(serviceItemId);
		serviceItem = result.get();

		assertThat(serviceItem.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadServiceItemDateOfService() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		ServiceItem serviceItem = serviceItemRepo.save(new ServiceItem(invoice));
		LocalDate date = LocalDate.of(2020, 03, 28);
		serviceItem.setDateOfService(date);
		long serviceItemId = serviceItem.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<ServiceItem> result = serviceItemRepo.findById(serviceItemId);
		serviceItem = result.get();

		assertEquals(serviceItem.getDateOfService(), date);
	}

	@Test
	public void shouldEstablishInvoiceToServiceItemRelationship() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		ServiceItem serviceItemOne = serviceItemRepo.save(new ServiceItem(invoice));
		ServiceItem serviceItemTwo = serviceItemRepo.save(new ServiceItem(invoice));
		long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<Invoice> result = invoiceRepo.findById(invoiceId);
		invoice = result.get();

		assertThat(invoice.getServiceItems(), containsInAnyOrder(serviceItemOne, serviceItemTwo));
	}

	@Test
	public void shouldEstablishContractorToInvoiceRelationship() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoiceOne = invoiceRepo.save(new Invoice(contractor));
		Invoice invoiceTwo = invoiceRepo.save(new Invoice(contractor));
		long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();

		assertThat(contractor.getInvoices(), containsInAnyOrder(invoiceOne, invoiceTwo));
	}

}
