package com.invoicetracker.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "contractorId")
public class Contractor extends User {
	
	/************************ Field Values ****************/

//	@Id
//	@GeneratedValue
//	private long id;

	@OneToMany(mappedBy = "contractor")
	private Collection<InvoiceImp> invoices;
	
	@ManyToMany
	private Collection<Agency> agencies;
	
	@ManyToMany(mappedBy = "contractors")
	private Collection<CustomerImp> customers;
	
	private String payPalId;
	

	/************************ Getters and Setters ****************/
	
//	public long getId() {
//		return id;
//	}

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

	/************************ Overrides ****************/
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (id ^ (id >>> 32));
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Contractor other = (Contractor) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}

}
