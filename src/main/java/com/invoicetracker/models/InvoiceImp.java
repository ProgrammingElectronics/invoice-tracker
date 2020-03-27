package com.invoicetracker.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "invoiceImpId")
public class InvoiceImp extends Invoice {
	
	/************************ Field Values ****************/

	@ManyToOne
	Contractor contractor;
	
	@ManyToOne
	Agency agency;
	
	@ManyToMany
	private Collection<Customer> customers;
	
	/************************ Getters and Setter ****************/
	
	public Contractor getContractor() {
		return contractor;
	}

	public Agency getAgency() {
		return agency;
	}

}
