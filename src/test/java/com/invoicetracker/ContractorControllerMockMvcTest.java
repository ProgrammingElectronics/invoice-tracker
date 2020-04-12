package com.invoicetracker;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.invoicetracker.controllers.ContractorController;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.InvoiceRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(SpringRunner.class)
@WebMvcTest(ContractorController.class)
public class ContractorControllerMockMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private ContractorController underTest;

	@MockBean
	private ContractorRepository contractorRepo;

	@MockBean
	private InvoiceRepository invoiceRepo;

	@Mock
	private Contractor contractorOne;

	@Mock
	private Invoice invoiceOne;

	@Mock
	private Invoice invoiceTwo;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}

	@Test
	public void shouldGetStatusOfOkWhenNavigatingToViewInvoice() throws Exception {
		long contractorId = 1;
		long invoiceId = 2;
		when(contractorRepo.findById(contractorId)).thenReturn(Optional.of(contractorOne));
		when(invoiceRepo.findById(invoiceId)).thenReturn(Optional.of(invoiceOne));
		this.mockMvc.perform(get("/contractor/view-existing-invoice/" + contractorId + "/" + invoiceId))
				.andExpect(status().isOk()).andExpect(view().name("view-invoice"));
	}

	@Test
	public void shouldGetStatusOfOkWhenNavigatingToSearchInvoiceList() throws Exception {
		long contractorId = 1;
		when(contractorRepo.findById(contractorId)).thenReturn(Optional.of(contractorOne));
		this.mockMvc.perform(get("/contractor/search-invoice-list/" + contractorId)).andExpect(status().isOk())
				.andExpect(view().name("search-invoice-list"));
	}

	/*
	 * TODO: These tests need fixed.   
	 */
	@Test
	public void MarkPaidEndPointWillMarkAnInvoicePaid() throws Exception {
		long invoiceId = 1;
		this.mockMvc.perform(put("/contractor/mark-invoice-paid/" + invoiceId)).andExpect(status().isOk());
	}
	
	@Test
	public void MarkSentEndPointWillMarkAnInvoiceSent() throws Exception {
		long invoiceId = 1;
		this.mockMvc.perform(put("/contractor/mark-invoice-sent/" + invoiceId)).andExpect(status().isOk());
	}

}
