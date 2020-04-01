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
import com.invoicetracker.repositories.ContractorRepository;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@WebMvcTest(ContractorController.class)
public class ContractorControllerMockMvcTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContractorRepository contractorRepo;
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToCreateInvoice() throws Exception {
		this.mockMvc.perform(get("/contractor/create-invoice")).andExpect(status().isOk())
		.andExpect(view().name("invoice-creation-view"));
	}

	@Test
	public void shouldGetStatusOfOkWhenNavigatingToViewInvoice() throws Exception {
		this.mockMvc.perform(get("/contractor/view-invoice")).andExpect(status().isOk())
		.andExpect(view().name("invoice-viewing-view"));
	}
	

}
