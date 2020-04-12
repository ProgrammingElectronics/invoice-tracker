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
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
class InvoiceTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	ContractorRepository contractorRepo;

	@Resource
	ServiceItemRepository serviceItemRepo;

	@Resource
	InvoiceRepository invoiceRepo;

	@Test
	void shouldSumServiceItemsAmountDue() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		ServiceItem serviceItemOne = serviceItemRepo.save(new ServiceItem(invoice));
		ServiceItem serviceItemTwo = serviceItemRepo.save(new ServiceItem(invoice));
		serviceItemOne.setAmountDue(300);
		serviceItemTwo.setAmountDue(400);
		long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		float result = invoiceRepo.findById(invoiceId).get().calculateTotalAmountDueFromAllServiceItemsOnInvoice();

		assertEquals(700, result, 0.01);
	}

	@Test
	void shouldRemoveServiceItem() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		@SuppressWarnings("unused")
		ServiceItem serviceItemOne = serviceItemRepo.save(new ServiceItem(invoice));
		ServiceItem serviceItemTwo = serviceItemRepo.save(new ServiceItem(invoice));
		long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Invoice result = invoiceRepo.findById(invoiceId).get();
		result.removeServiceItem(serviceItemTwo);

		assertEquals(1, result.getServiceItems().size());
	}

	@Test
	void shouldReturnThreeServiceItemCustomerNamesAsACommaSeparatedString() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		ServiceItem serviceItemOne = serviceItemRepo.save(new ServiceItem(invoice));
		ServiceItem serviceItemTwo = serviceItemRepo.save(new ServiceItem(invoice));
		serviceItemOne.setServiceDescription("bill");
		serviceItemTwo.setServiceDescription("ted");
		long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Invoice result = invoiceRepo.findById(invoiceId).get();

		assertEquals("bill, ted", result.getCustomerNamePreviewAsString());
	}

	@Test
	void shouldClipNumberOfServiceItemCustomerNamesOver3() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		ServiceItem serviceItemOne = serviceItemRepo.save(new ServiceItem(invoice));
		ServiceItem serviceItemTwo = serviceItemRepo.save(new ServiceItem(invoice));
		ServiceItem serviceItemThree = serviceItemRepo.save(new ServiceItem(invoice));
		ServiceItem serviceItemFour = serviceItemRepo.save(new ServiceItem(invoice));
		serviceItemOne.setServiceDescription("bill");
		serviceItemTwo.setServiceDescription("ted");
		serviceItemThree.setServiceDescription("excellent");
		serviceItemFour.setServiceDescription("Yeah");
		long invoiceId = invoice.getId();

		// Act
		entityManager.flush();
		entityManager.clear();
		Invoice result = invoiceRepo.findById(invoiceId).get();

		assertEquals("bill, ted ... plus 2 more", result.getCustomerNamePreviewAsString());
	}

	@Test
	void shouldFormatTotalAmountDueAsCurrency() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		ServiceItem serviceItemOne = serviceItemRepo.save(new ServiceItem(invoice));
		ServiceItem serviceItemTwo = serviceItemRepo.save(new ServiceItem(invoice));
		serviceItemOne.setAmountDue(300);
		serviceItemTwo.setAmountDue(400);
		long invoiceId = invoice.getId();
		// Act
		entityManager.flush();
		entityManager.clear();
		Invoice result = invoiceRepo.findById(invoiceId).get();

		assertEquals("$700.00", result.getTotalAmountDueAsCurrencyString());
	}

	@Test
	void shouldReturnStringPaidIfInvoiceIsPaid() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
		long invoiceId = invoice.getId();
		// Act
		entityManager.flush();
		entityManager.clear();
		Invoice result = invoiceRepo.findById(invoiceId).get();
		result.setIsPaid(true);
		
		assertEquals("Paid", result.showPaymentStatus());
	}

}
