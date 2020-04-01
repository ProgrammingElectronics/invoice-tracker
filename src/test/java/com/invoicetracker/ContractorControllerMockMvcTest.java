package com.invoicetracker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.invoicetracker.controllers.ContractorController;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.InvoiceImp;
import com.invoicetracker.repositories.ContractorRepository;

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
		this.mockMvc.perform(get("/search-invoice-list/1L")).andExpect(status().isOk())
		.andExpect(view().name("search-invoice-list"));
	}

}
