package com.invoicetracker.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "agencyId")
public class Agency extends User {

	/************************ Field Values ****************/
	
	@ManyToMany(mappedBy = "agencies")
	private Collection<Contractor> contractors;
	
	@OneToMany
	private Collection<InvoiceImp> invoices;
	
	@OneToMany(mappedBy = "agency")
	private Collection<CustomerImp> customers;
	
	/************************ Getters and Setters ****************/
	
	public Collection<Contractor> getContractors() {
		return contractors;
	}
	
	public Collection<InvoiceImp> getInvoices() {
		return invoices;
	}

	public Collection<CustomerImp> getCustomers() {
		return customers;
	}

}
