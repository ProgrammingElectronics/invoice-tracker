package com.invoicetracker.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoicetracker.models.Contractor;
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
	
	@GetMapping("/view-invoice-list/{contractorId}")
	private String viewInvoiceList(@PathVariable(value="contractorId") long contractorId, Model model) {		
		
		Contractor contractor = contractorRepo.findById(contractorId).get();
		model.addAttribute("invoices", contractor.getInvoices());
		
		return "search-invoice-list";
	}

}
