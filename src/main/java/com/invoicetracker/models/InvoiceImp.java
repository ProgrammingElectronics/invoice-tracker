package com.invoicetracker.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import net.bytebuddy.implementation.bind.annotation.Super;

@Entity
@PrimaryKeyJoinColumn(name = "invoiceImpId")
public class InvoiceImp extends Invoice {

	/************************ Field Values ****************/

	@ManyToOne
	Contractor contractor;

	@ManyToOne
	Agency agency;

	@OneToMany
	private Collection<ServiceItem> serviceItems;

	/************************ Getters and Setter ****************/

	public Contractor getContractor() {
		return contractor;
	}

	public Agency getAgency() {
		return agency;
	}

	public Collection<ServiceItem> getServiceItems() {
		return serviceItems;
	}
	
	
	/************************ Constructors ****************/

	public InvoiceImp() {
	}

	public InvoiceImp(LocalDate dateOfInvoice) {
		super(dateOfInvoice);
	}

	public InvoiceImp(LocalDate dateOfInvoice, ServiceItem...serviceItems) {
		super(dateOfInvoice);
		this.serviceItems = new HashSet<>(Arrays.asList(serviceItems));
	}

}
