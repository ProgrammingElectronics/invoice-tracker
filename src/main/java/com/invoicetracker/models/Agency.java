package com.invoicetracker.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "agencyId")
public class Agency extends User {

	/************************ Field Values ****************/
	
	private String businessName;
	
	@ManyToMany
	private Collection<Contractor> contractors;
	
	@OneToMany
	private Collection<Invoice> invoices;
	
	@OneToMany(mappedBy = "agency")
	private Collection<Customer> customers;
	

	/************************ Getters and Setters ****************/
	
	public String getBusinessName() {
		return businessName;
	}
	
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	public Collection<Contractor> getContractors() {
		return contractors;
	}
	
	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	/************************ Constructor ****************/
	
	public Agency() {}
	
	public Agency(String businessName) {
		this.businessName = businessName;
	}

	public Agency(String businessName, Contractor... contractors) {
		this.businessName = businessName;
		this.contractors = new HashSet<>(Arrays.asList(contractors));
	}
	
}
