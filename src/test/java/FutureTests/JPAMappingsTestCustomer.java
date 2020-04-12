package FutureTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.invoicetracker.models.Customer;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

class JPAMappingsTestCustomer {
	
	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ContractorRepository contractorRepo;

	@Resource
	private InvoiceRepository invoiceRepo;

	@Resource
	private ServiceItemRepository serviceItemRepo;

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

		assertEquals(serviceItem.getCustomer(), customerOne);
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


}
