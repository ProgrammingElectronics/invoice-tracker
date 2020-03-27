package com.invoicetracker.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "contractorId")
public class Contractor extends User {

	/************************ Field Values ****************/

	@OneToMany(mappedBy = "contractor")
	private Collection<InvoiceImp> invoices;
	
	@ManyToMany
	private Collection<Agency> agencies;
	
	@ManyToMany(mappedBy = "contractors")
	private Collection<CustomerImp> customers;
	
	private String payPalId;
	

	/************************ Getters and Setters ****************/

	public String getPayPalId() {
		return payPalId;
	}

	public void setPayPalId(String payPalId) {
		this.payPalId = payPalId;
	}
	
	public Collection<InvoiceImp> getInvoices() {
		return invoices;
	}
	
	public Collection<Agency> getAgencies() {
		return agencies;
	}

	public Collection<CustomerImp> getCustomers() {
		return customers;
	}

	
	/************************ Constructors ****************/
	
	public Contractor() {}
	
	public Contractor(String firstName) {
		super(firstName);
	}

}
