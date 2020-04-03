package com.invoicetracker;

import java.time.LocalDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.invoicetracker.models.Agency;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.Customer;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.AgencyRepository;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.CustomerRepository;
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
	private AgencyRepository agencyRepo;

	@Resource
	private InvoiceRepository invoiceRepo;

	@Resource
	private ServiceItemRepository serviceItemRepo;

	@Resource
	private CustomerRepository customerRepo;

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
		assertEquals(contractor.getAgency(), agency);

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
		Invoice invoice = invoiceRepo.save(new Invoice(date));
		Long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Invoice> result = invoiceRepo.findById(invoiceId);
		invoice = result.get();

		// Assert
		assertEquals(invoice.getDateOfInvoice(), date);
	}

	@Test
	public void shouldGenerateInvoiceId() {
		// Arrange
		LocalDate date = LocalDate.of(2020, 03, 28);
		Invoice invoice = invoiceRepo.save(new Invoice(date));
		Long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Invoice> result = invoiceRepo.findById(invoiceId);
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
		Invoice invoice = invoiceRepo.save(new Invoice(dateOfInvoice, serviceOne, serviceTwo));
		long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Invoice> result = invoiceRepo.findById(invoiceId);
		invoice = result.get();

		// Assert
		assertThat(invoice.getServiceItems(), containsInAnyOrder(serviceOne, serviceTwo));
	}

	@Test
	public void shouldEstablishServiceItemToInvoiceRelationship() {
		// Arrange
		LocalDate dateOfInvoice = LocalDate.of(2020, 03, 29);
		Invoice invoice = invoiceRepo.save(new Invoice(dateOfInvoice));
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
		Customer customer = customerRepo.save(new Customer("testName"));
		long customerId = customer.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Customer> result = customerRepo.findById(customerId);
		customer = result.get();

		assertThat(customer.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadCustomerName() {
		// Arrange
		Customer customer = customerRepo.save(new Customer("testName"));
		long customerId = customer.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Customer> result = customerRepo.findById(customerId);
		customer = result.get();

		assertEquals(customer.getCustomerName(), "testName");
	}

	@Test
	public void shouldEstablishServiceItemToCustomerRelationship() {
		// Arrange
		Customer customerOne = customerRepo.save(new Customer("testNameOne"));
		LocalDate dateOfService = LocalDate.of(2020, 03, 29);
		ServiceItem serviceItem = serviceItemRepo.save(new ServiceItem(dateOfService, customerOne));
		long serviceId = serviceItem.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<ServiceItem> result = serviceItemRepo.findById(serviceId);
		serviceItem = result.get();
		String customerName = serviceItem.getCustomer().getCustomerName();

		assertEquals(customerName, customerOne.getCustomerName());
	}

	@Test
	public void shouldEstablishCustomerToServiceItemRelationship() {
		// Arrange
		LocalDate dateOfServiceOne = LocalDate.of(2020, 03, 29);
		LocalDate dateOfServiceTwo = LocalDate.of(2020, 03, 30);
		ServiceItem serviceItemOne = serviceItemRepo.save(new ServiceItem(dateOfServiceOne));
		ServiceItem serviceItemTwo = serviceItemRepo.save(new ServiceItem(dateOfServiceTwo));
		Customer customer = customerRepo.save(new Customer("testNameTwo", serviceItemOne, serviceItemTwo));
		long customerId = customer.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Customer> result = customerRepo.findById(customerId);
		customer = result.get();

		assertThat(customer.getServiceItems(), containsInAnyOrder(serviceItemOne, serviceItemTwo));
	}

	@Test
	public void shouldEstablishContractorToInvoiceRelationship() {
		// Arrange
		Invoice invoiceOne = invoiceRepo.save(new Invoice());
		Invoice invoiceTwo = invoiceRepo.save(new Invoice());
		Contractor contractor = contractorRepo.save(new Contractor(invoiceOne, invoiceTwo));
		long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();

		assertThat(contractor.getInvoices(), containsInAnyOrder(invoiceOne, invoiceTwo));
	}
	
	
}
