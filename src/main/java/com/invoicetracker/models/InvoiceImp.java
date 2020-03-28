package com.invoicetracker.models;

import java.time.LocalDate;
import java.util.Collection;

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

	/************************ Constructors ****************/

	public InvoiceImp() {
	}

	public InvoiceImp(LocalDate dateOfInvoice) {
		super(dateOfInvoice);
	}

}
