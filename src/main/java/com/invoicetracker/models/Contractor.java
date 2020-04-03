package com.invoicetracker.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "contractorId")
public class Contractor extends User {

	/************************ Field Values ****************/

	private String firstName;
	private String lastName;
	private String payPalId;

	/*
	 * CODE REVIEW NEEDED. I need to understand why this mapped 
	 * is breaking the JPAMappingsTest shouldEstablishContractorToInvoiceImpRelationship 
	 */
	@OneToMany // (mappedBy = "contractor")
	private Collection<Invoice> invoices;

	@ManyToOne
	private Agency agency;

	@OneToMany(mappedBy = "contractors")
	private Collection<Customer> customers;

	/************************ Getters and Setters ****************/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPayPalId() {
		return payPalId;
	}

	public void setPayPalId(String payPalId) {
		this.payPalId = payPalId;
	}

	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	public Agency getAgency() {
		return agency;
	}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	/************************ Constructors ****************/

	public Contractor() {
	}

	public Contractor(String firstName) {
		this.firstName = firstName;
	}

	public Contractor(String firstName, Agency agency) {
		this.firstName = firstName;
		this.agency = agency;
	}

	public Contractor(Invoice... invoices) {
		this.invoices = new HashSet<>(Arrays.asList(invoices));
	}

	public Contractor(String firstName, Invoice...invoices) {
		this.firstName = firstName;
		this.invoices = new HashSet<>(Arrays.asList(invoices));
	}

}
