package com.invoicetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoicetracker.models.Contractor;
import com.invoicetracker.repositories.ContractorRepository;

@RestController
public class ContractorProfileController {

	@Autowired
	ContractorRepository contractorRepo;
	
	@PostMapping("/update-profile/{contractorId}")
	public Contractor update(@RequestBody Contractor updatedContractor, @PathVariable long contractorId) {
		Contractor contractorToUpdate = contractorRepo.findById(contractorId).get();
		contractorToUpdate.setFirstName(updatedContractor.getFirstName());
		contractorRepo.save(contractorToUpdate);
		return contractorToUpdate;
	}
}
