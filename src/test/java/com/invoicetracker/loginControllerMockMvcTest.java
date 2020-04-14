package com.invoicetracker;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.invoicetracker.controllers.LoginController;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
class loginControllerMockMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private LoginController underTest;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}

	@Test
	void shouldGetStatusOfOkWhenNavigatingToLoginScreen() throws Exception {
		this.mockMvc.perform(get("/login")).andExpect(status().isOk());
	}
	
	@Test
	void shouldGetViewContratorLoginWhenNavigatingToLoginScreen() throws Exception {
		this.mockMvc.perform(get("/login")).andExpect(view().name("contractor-login"));
	}

}
