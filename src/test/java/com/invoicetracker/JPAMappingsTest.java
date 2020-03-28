package com.invoicetracker;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.invoicetracker.Repositories.AgencyRespository;
import com.invoicetracker.Repositories.ContractorRepository;
import com.invoicetracker.models.Agency;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.CustomerImp;
import com.invoicetracker.models.InvoiceImp;
import com.invoicetracker.models.ServiceItem;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ContractorRepository contractorRepo;

	@Resource
	private AgencyRespository agencyRepo;

	@Resource
	private InvoiceImpRespository invoiceRepo;

	@Resource
	private ServiceItemRespository serviceItemRepo;

	@Resource
	private CustomerImpRespository customerRepo;

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

		// Assert
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

		// Assert
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

		// Assert
		assertThat(contractor.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadAgencyBusinessName() {

		// Arrange
		Agency agency = agencyRepo.save(new Agency("businessName"));
		Long agencyId = agency.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Agency> result = agencyRepo.findById(agencyId);
		agency = result.get();

		// Assert
		assertEquals(agency.getBusinessName(), "businessName");
	}

	@Test
	public void shouldGenerateAgencyId() {

		// Arrange
		Agency agency = agencyRepo.save(new Agency("businessName"));
		Long agencyId = agency.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Agency> result = agencyRepo.findById(agencyId);
		agency = result.get();

		// Assert
		assertThat(agency.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldEstablishContractorToAgencyRelationship() {
		// Arrange
		Agency agency = agencyRepo.save(new Agency("test"));
		Contractor contractor = contractorRepo.save(new Contractor("testContractor", agency));

		Long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();

		// Assert
		assertThat(contractor.getAgencies(), containsInAnyOrder(agency));

	}

	@Test
	public void shouldEstablishAgencyToContractorRelationship() {
		// Arrange
		Contractor contractorOne = contractorRepo.save(new Contractor("testContractorOne"));
		Contractor contractorTwo = contractorRepo.save(new Contractor("testContractorTwo"));
		Agency agency = agencyRepo.save(new Agency("test", contractorOne, contractorTwo));
		Long agencyId = agency.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Agency> result = agencyRepo.findById(agencyId);
		agency = result.get();

		// Assert
		assertThat(agency.getContractors(), containsInAnyOrder(contractorOne, contractorTwo));

	}

	@Test
	public void shouldSaveAndLoadInvoiceDateOfService() {
		// Arrange
		LocalDate date = LocalDate.of(2020, 03, 28);
		InvoiceImp invoice = invoiceRepo.save(new InvoiceImp(date));
		Long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<InvoiceImp> result = invoiceRepo.findById(invoiceId);
		invoice = result.get();

		// Assert
		assertEquals(invoice.getDateOfInvoice(), date);
	}

	@Test
	public void shouldGenerateInvoiceId() {
		// Arrange
		LocalDate date = LocalDate.of(2020, 03, 28);
		InvoiceImp invoice = invoiceRepo.save(new InvoiceImp(date));
		Long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<InvoiceImp> result = invoiceRepo.findById(invoiceId);
		invoice = result.get();

		// Assert
		assertThat(invoice.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldGenerateServiceItemId() {
		// Arrange
		LocalDate date = LocalDate.of(2020, 03, 28);
		ServiceItem serviceItem = serviceItemRepo.save(new ServiceItem(date));
		long serviceItemId = serviceItem.getId();

		// Act
		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<ServiceItem> result = serviceItemRepo.findById(serviceItemId);
		serviceItem = result.get();

		// Assert
		assertThat(serviceItem.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadServiceItemDateOfService() {
		// Arrange
		LocalDate date = LocalDate.of(2020, 03, 28);
		ServiceItem serviceItem = serviceItemRepo.save(new ServiceItem(date));
		long serviceItemId = serviceItem.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<ServiceItem> result = serviceItemRepo.findById(serviceItemId);
		serviceItem = result.get();

		// Assert
		assertEquals(serviceItem.getDateOfService(), date);
	}

	@Test
	public void shouldEstablishInvoiceToServiceItemRelationship() {
		// Arrange
		LocalDate dateServiceOne = LocalDate.of(2020, 03, 28);
		LocalDate dateServiceTwo = LocalDate.of(2020, 03, 29);
		ServiceItem serviceOne = serviceItemRepo.save(new ServiceItem(dateServiceOne));
		ServiceItem serviceTwo = serviceItemRepo.save(new ServiceItem(dateServiceTwo));
		LocalDate dateOfInvoice = LocalDate.of(2020, 03, 29);
		InvoiceImp invoice = invoiceRepo.save(new InvoiceImp(dateOfInvoice, serviceOne, serviceTwo));
		long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<InvoiceImp> result = invoiceRepo.findById(invoiceId);
		invoice = result.get();

		// Assert
		assertThat(invoice.getServiceItems(), containsInAnyOrder(serviceOne, serviceTwo));
	}

	@Test
	public void shouldEstablishServiceItemToInvoiceRelationship() {
		// Arrange
		LocalDate dateOfInvoice = LocalDate.of(2020, 03, 29);
		InvoiceImp invoice = invoiceRepo.save(new InvoiceImp(dateOfInvoice));
		LocalDate dateOfService = LocalDate.of(2020, 03, 29);
		ServiceItem serviceItem = serviceItemRepo.save(new ServiceItem(dateOfService, invoice));
		long serviceItemId = serviceItem.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<ServiceItem> result = serviceItemRepo.findById(serviceItemId);
		serviceItem = result.get();

		// Assert
		assertEquals(serviceItem.getInvoice(), invoice);
	}

	@Test
	public void shouldGenerateCustomerId() {
		// Arrange
		CustomerImp customer = customerRepo.save(new CustomerImp("testName"));
		long customerId = customer.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<CustomerImp> result = customerRepo.findById(customerId);
		customer = result.get();

		assertThat(customer.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadCustomerName() {
		// Arrange
		CustomerImp customer = customerRepo.save(new CustomerImp("testName"));
		long customerId = customer.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<CustomerImp> result = customerRepo.findById(customerId);
		customer = result.get();

		assertEquals(customer.getCustomerName(), "testName");
	}

	@Test
	public void shouldEstablishServiceItemToCustomerRelationship() {
		// Arrange
		CustomerImp customerOne = customerRepo.save(new CustomerImp("testNameOne"));
		CustomerImp customerTwo = customerRepo.save(new CustomerImp("testNameTwo"));
		LocalDate dateOfService = LocalDate.of(2020, 03, 29);
		ServiceItem serviceItem = serviceItemRepo.save(new ServiceItem(dateOfService, customerOne, customerTwo));
		long serviceId = serviceItem.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		
		Optional<ServiceItem> result = serviceItemRepo.findById(serviceId);
		serviceItem = result.get();
		
		assertThat(serviceItem.getCustomers(), containsInAnyOrder(customerOne, customerTwo));
	}

	@Test
	public void shouldEstablishCustomerToServiceItemRelationship() {
		// Arrange
		LocalDate dateOfServiceOne = LocalDate.of(2020, 03, 29);
		LocalDate dateOfServiceTwo = LocalDate.of(2020, 03, 30);
		ServiceItem serviceItemOne = serviceItemRepo.save(new ServiceItem(dateOfServiceOne));
		ServiceItem serviceItemTwo = serviceItemRepo.save(new ServiceItem(dateOfServiceTwo));
		CustomerImp customer = customerRepo.save(new CustomerImp("testNameTwo", serviceItemOne, serviceItemTwo));
		long customerId = customer.getId();
		
		// Act
		entityManager.flush();
		entityManager.clear();
		
		Optional<CustomerImp> result = customerRepo.findById(customerId);
		customer = result.get();
		
		assertThat(customer.getServiceItems(), containsInAnyOrder(serviceItemOne, serviceItemTwo));
	}

}
