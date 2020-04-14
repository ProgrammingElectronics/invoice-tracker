package com.invoicetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.repositories.ContractorRepository;

@RestController
public class ContractorProfileController {

	@Autowired
	ContractorRepository contractorRepo;

	/**
	 * 
	 * TODO Needs Code review.
	 * I don't like all these if's.  
	 * Can I iterate through an index the @RequestBody items, check if they are not null,
	 * and if so, add them to an "filtered" contractor?
	 * 
	 */
	@PatchMapping("/update-profile/{contractorId}")
	public Contractor update(@RequestBody Contractor update, @PathVariable long contractorId) {
		
		Contractor contractor = contractorRepo.findById(contractorId).get();

		if (update.getFirstName() != "")
			contractor.setFirstName(update.getFirstName());
		if (update.getLastName() != "")
			contractor.setLastName(update.getLastName());
		if (update.getAddressLineOne() != "")
			contractor.setAddressLineOne(update.getAddressLineOne());
		if (update.getAddressLineTwo() != "")
			contractor.setAddressLineTwo(update.getAddressLineTwo());
		if (update.getCity() != "")
			contractor.setCity(update.getCity());
		if (update.getState() != "")
			contractor.setState(update.getState());
		if (update.getZip() != "")
			contractor.setZip(update.getZip());
		if (update.getCountry() != "")
			contractor.setCountry(update.getCountry());
		if (update.getPhoneNumber() != "")
			contractor.setPhoneNumber(update.getPhoneNumber());
		if (update.getEmail() != "")
			contractor.setEmail(update.getEmail());
		if (update.getPayPalId() != "")
			contractor.setPayPalId(update.getPayPalId());
		contractorRepo.save(contractor);
		return contractor;
	}

	@GetMapping("/api/contractor/{id}")
	public Contractor retrieveContractor(@PathVariable Long id) {
		return contractorRepo.findById(id).get();
	}
	
}