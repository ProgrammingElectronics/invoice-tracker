package com.invoicetracker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.invoicetracker.controllers.ContractorController;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.InvoiceImp;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.InvoiceImpRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;


@RunWith(SpringRunner.class)
@WebMvcTest(ContractorController.class)
public class ContractorControllerMockMvcTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContractorRepository contractorRepo;

	@MockBean
	private InvoiceImpRepository invoiceRepo;
	
	@Mock
	private Contractor contractorOne;
	
	@Mock
	private InvoiceImp invoiceOne;

	@Mock
	private InvoiceImp invoiceTwo;
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToCreateInvoice() throws Exception {
		this.mockMvc.perform(get("/contractor/create-invoice")).andExpect(status().isOk())
		.andExpect(view().name("create-invoice"));
	}

	@Test
	public void shouldGetStatusOfOkWhenNavigatingToViewInvoice() throws Exception {
		this.mockMvc.perform(get("/contractor/view-invoice")).andExpect(status().isOk())
		.andExpect(view().name("view-invoice"));
	}
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToSearchInvoiceList() throws Exception {
		LocalDate dateOne = LocalDate.of(2020, 4, 01);
		InvoiceImp invoiceTestOne = invoiceRepo.save(new InvoiceImp(dateOne));

		LocalDate dateTwo = LocalDate.of(2020, 4, 01);
		InvoiceImp invoiceTestTwo = invoiceRepo.save(new InvoiceImp(dateTwo));
		
		Contractor contractor = contractorRepo.save(new Contractor(invoiceTestOne, invoiceTestTwo));
		
		long contractorId = contractor.getId();
		System.out.println(contractorId);
		
		this.mockMvc.perform(get("/search-invoice-list/" + contractorId)).andExpect(status().isOk())
		.andExpect(view().name("search-invoice-list"));
	}

}
