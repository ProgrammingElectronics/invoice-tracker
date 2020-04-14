package com.invoicetracker.controllers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;
import com.invoicetracker.models.ServiceItem;

@RestController
public class InvoiceRestController {

	@Autowired
	private InvoiceRepository invoiceRepo;

	@Autowired
	private ContractorRepository contractorRepo;

	@Autowired
	private ServiceItemRepository serviceItemRepo;

	/************ ^ Autowired Repos | v Mapping methods **************/

	@GetMapping("/api/invoice/{id}")
	public Invoice retrieveInvoice(@PathVariable Long id) {

		return invoiceRepo.findById(id).get();
	}

	@PostMapping("/submit-invoice")
	public Invoice add(@RequestBody Invoice invoiceToAdd) {
		invoiceRepo.save(invoiceToAdd);
		for (ServiceItem serviceItemToAdd : invoiceToAdd.getServiceItems()) {
			serviceItemToAdd.setInvoice(invoiceToAdd);
			serviceItemRepo.save(serviceItemToAdd);
		}

		// contractorRepo.save(invoiceToAdd.getContractor());

		return invoiceRepo.save(invoiceToAdd);
	}
}
