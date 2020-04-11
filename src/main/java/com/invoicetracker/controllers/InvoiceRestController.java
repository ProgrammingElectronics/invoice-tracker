package com.invoicetracker.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.invoicetracker.models.Invoice;
import com.invoicetracker.repositories.InvoiceRepository;

@RestController
public class InvoiceRestController {

	@Resource
	private InvoiceRepository invoiceRepo;

	@GetMapping("/api/invoice/{id}")
	public Invoice retrieveInvoice(@PathVariable Long id) {
		return invoiceRepo.findById(id).get();
	}
}
