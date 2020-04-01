package com.invoicetracker.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoicetracker.repositories.ContractorRepository;

@RequestMapping("/contractor")
@Controller
public class ContractorController {
	
	@Resource
	private ContractorRepository contractorRepo;
	
	
	@GetMapping("/create-invoice")
	private String createInvoice() {	
		return "create-invoice";	
	}

	@GetMapping("/view-invoice")
	private String viewInvoice() {	
		return "view-invoice";	
	}

}
