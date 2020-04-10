package com.invoicetracker;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

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
		//Arrange
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
		//Arrange
		Contractor contractor = contractorRepo.save(new Contractor());
		Invoice invoice = invoiceRepo.save(new Invoice(contractor));
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

//	@Test
//	void shouldReturnThreeServiceItemCustomerNamesAsACommaSeparatedString() {
//
//		// TODO: Make all this invoice code into a mock...somehow
//		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
//		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
//		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1);
//		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1);
//		serviceItemOneInv1.setCustomerName("bill");
//		serviceItemTwoInv1.setCustomerName("ted");
//		serviceItemRepo.save(serviceItemOneInv1);
//		serviceItemRepo.save(serviceItemTwoInv1);
//
//		LocalDate dateFourInv1 = LocalDate.of(2020, 4, 03);
//		Invoice invoiceOneInv1 = new Invoice(dateFourInv1, serviceItemOneInv1, serviceItemTwoInv1);
//		invoiceRepo.save(invoiceOneInv1);
//
//		String result = invoiceOneInv1.getCustomerNamePreviewAsString();
//
//		assertEquals("bill, ted", result);
//
//	}
//
//	@Test
//	void shouldClipNumberOfServiceItemCustomerNamesOver3() {
//		
//		// TODO: Make all this invoice code into a mock...somehow
//		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
//		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
//		LocalDate dateThreeInv1 = LocalDate.of(2019, 4, 02);
//		LocalDate dateFourInv1 = LocalDate.of(2019, 4, 02);
//		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1);
//		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1);
//		ServiceItem serviceItemThreeInv1 = new ServiceItem(dateThreeInv1);
//		ServiceItem serviceItemFourInv1 = new ServiceItem(dateThreeInv1);
//		serviceItemOneInv1.setCustomerName("bill");
//		serviceItemTwoInv1.setCustomerName("ted");
//		serviceItemThreeInv1.setCustomerName("excellent");
//		serviceItemFourInv1.setCustomerName("Yeah");
//		serviceItemRepo.save(serviceItemOneInv1);
//		serviceItemRepo.save(serviceItemTwoInv1);
//		serviceItemRepo.save(serviceItemThreeInv1);
//		serviceItemRepo.save(serviceItemFourInv1);
//		
//		LocalDate dateFiveInv1 = LocalDate.of(2020, 4, 03);
//		Invoice invoiceOneInv1 = new Invoice(dateFourInv1, serviceItemOneInv1, serviceItemTwoInv1,
//				serviceItemThreeInv1, serviceItemFourInv1);
//		invoiceRepo.save(invoiceOneInv1);
//		
//		String result = invoiceOneInv1.getCustomerNamePreviewAsString();
//		
//		assertEquals("bill, ted ... plus 2 more", result);
//		
//	}
//	
//	@Test
//	void shouldFormatTotalAmountDueAsCurrency() {
//		
//		// TODO: Make all this invoice code into a mock...somehow
//		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
//		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
//		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1);
//		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1);
//		serviceItemOneInv1.setAmountDue(300);
//		serviceItemTwoInv1.setAmountDue(400);
//		serviceItemRepo.save(serviceItemOneInv1);
//		serviceItemRepo.save(serviceItemTwoInv1);
//
//		LocalDate dateThreeInv1 = LocalDate.of(2020, 4, 03);
//		Invoice invoiceOneInv1 = new Invoice(dateThreeInv1, serviceItemOneInv1, serviceItemTwoInv1);
//		invoiceRepo.save(invoiceOneInv1);
//		
//		String result = invoiceOneInv1.formatTotalAmountDueAsCurrency();
//		
//		assertEquals("$700.00", result);
//		
//	}

}
