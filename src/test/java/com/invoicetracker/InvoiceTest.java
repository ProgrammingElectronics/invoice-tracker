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

		float result = invoiceOneInv1.calculateTotalAmountDueFromAllServiceItemsOnInvoice();

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

	@Test
	void shouldReturnThreeServiceItemCustomerNamesAsACommaSeparatedString() {

		// TODO: Make all this invoice code into a mock...somehow
		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1);
		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1);
		serviceItemOneInv1.setCustomerName("bill");
		serviceItemTwoInv1.setCustomerName("ted");
		serviceItemRepo.save(serviceItemOneInv1);
		serviceItemRepo.save(serviceItemTwoInv1);

		LocalDate dateFourInv1 = LocalDate.of(2020, 4, 03);
		Invoice invoiceOneInv1 = new Invoice(dateFourInv1, serviceItemOneInv1, serviceItemTwoInv1);
		invoiceRepo.save(invoiceOneInv1);

		String result = invoiceOneInv1.getCustomerNamePreviewAsString();

		assertEquals("bill, ted", result);

	}

	@Test
	void shouldClipNumberOfServiceItemCustomerNamesOver3() {
		
		// TODO: Make all this invoice code into a mock...somehow
		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
		LocalDate dateThreeInv1 = LocalDate.of(2019, 4, 02);
		LocalDate dateFourInv1 = LocalDate.of(2019, 4, 02);
		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1);
		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1);
		ServiceItem serviceItemThreeInv1 = new ServiceItem(dateThreeInv1);
		ServiceItem serviceItemFourInv1 = new ServiceItem(dateThreeInv1);
		serviceItemOneInv1.setCustomerName("bill");
		serviceItemTwoInv1.setCustomerName("ted");
		serviceItemThreeInv1.setCustomerName("excellent");
		serviceItemFourInv1.setCustomerName("Yeah");
		serviceItemRepo.save(serviceItemOneInv1);
		serviceItemRepo.save(serviceItemTwoInv1);
		serviceItemRepo.save(serviceItemThreeInv1);
		serviceItemRepo.save(serviceItemFourInv1);
		
		LocalDate dateFiveInv1 = LocalDate.of(2020, 4, 03);
		Invoice invoiceOneInv1 = new Invoice(dateFourInv1, serviceItemOneInv1, serviceItemTwoInv1,
				serviceItemThreeInv1, serviceItemFourInv1);
		invoiceRepo.save(invoiceOneInv1);
		
		String result = invoiceOneInv1.getCustomerNamePreviewAsString();
		
		assertEquals("bill, ted ... plus 2 more", result);
		
	}
	
	@Test
	void shouldFormatTotalAmountDueAsCurrency() {
		
		// TODO: Make all this invoice code into a mock...somehow
		LocalDate dateOneInv1 = LocalDate.of(2020, 4, 01);
		LocalDate dateTwoInv1 = LocalDate.of(2020, 4, 02);
		ServiceItem serviceItemOneInv1 = new ServiceItem(dateOneInv1);
		ServiceItem serviceItemTwoInv1 = new ServiceItem(dateTwoInv1);
		serviceItemOneInv1.setAmountDue(300);
		serviceItemTwoInv1.setAmountDue(400);
		serviceItemRepo.save(serviceItemOneInv1);
		serviceItemRepo.save(serviceItemTwoInv1);

		LocalDate dateThreeInv1 = LocalDate.of(2020, 4, 03);
		Invoice invoiceOneInv1 = new Invoice(dateThreeInv1, serviceItemOneInv1, serviceItemTwoInv1);
		invoiceRepo.save(invoiceOneInv1);
		
		String result = invoiceOneInv1.formatTotalAmountDueAsCurrency();
		
		assertEquals("$700.00", result);
		
	}

}
