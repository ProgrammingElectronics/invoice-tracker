package com.invoicetracker.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Agency extends User {
	
	/************************ Field Values ****************/
	
	@Id
	@GeneratedValue
	private long id;

	@ManyToMany(mappedBy = "agencies")
	private Collection<Contractor> contractors;
	
	@OneToMany
	private Collection<InvoiceImp> invoices;
	
	@OneToMany(mappedBy = "agency")
	private Collection<CustomerImp> customers;
	
	/************************ Getters and Setters ****************/
	
	public long getId() {
		return id;
	}
	
	public Collection<Contractor> getContractors() {
		return contractors;
	}
	
	public Collection<InvoiceImp> getInvoices() {
		return invoices;
	}

	public Collection<CustomerImp> getCustomers() {
		return customers;
	}

	/************************ Overrides ****************/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agency other = (Agency) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
