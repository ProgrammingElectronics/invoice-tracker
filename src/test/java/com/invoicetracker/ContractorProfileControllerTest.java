package com.invoicetracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.invoicetracker.controllers.ContractorProfileController;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.repositories.ContractorRepository;

public class ContractorProfileControllerTest {

	@Mock
	private ContractorRepository contractorRepo;
	
	/*
	 * TODO:  Need to understand This @InjectMock annotation better.
	 */
	@InjectMocks
	private ContractorProfileController underTest;
	private Contractor newContractor;
	
	/*
	 * TODO:  Need to understand these two object better
	 */
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;
	
	/*
	 * TODO:  Need to understand all the setup methids being called and why.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		newContractor = new Contractor("Mike");
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
		objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToUpdateContractorEndPoint() throws Exception {
		Contractor contractor = new Contractor("Test");	
		Contractor updatedContractor = new Contractor("The contractor formerly known as Test");	
		long contractorId = 1;
		when(contractorRepo.findById(contractorId)).thenReturn(Optional.of(contractor));
		when(contractorRepo.save(newContractor)).thenReturn(contractor);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String contractorJson = mapper.writeValueAsString(updatedContractor);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
		mockMvc.perform(post("/update-profile/" + contractorId)
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8")
				.content(contractorJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("The contractor formerly known as Test")));
		}

}
