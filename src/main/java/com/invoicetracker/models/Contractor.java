package com.invoicetracker.models;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contractor extends User {

	/************************ Field Values ****************/

	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	private String lastName;
	private String payPalId;
	private int currentInvoiceNumber = 1000;

	@JsonIgnore
	@OneToMany(mappedBy = "contractor")
	private Collection<Invoice> invoices;

	/************************ Getters and Setters ****************/

	public long getId() {
		return id;
	}
	
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

	public int getCurrentInvoiceNumber() {
		return currentInvoiceNumber;
	}

	public void incrementCurrentInvoiceNumber() {
		this.currentInvoiceNumber++;
	}

	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	/************************ Methods ****************/
	
	public void addInvoice(Invoice newInvoice) {
		
		getInvoices().add(newInvoice);
		newInvoice.setContractor(this);
	}

	public void removeInvoice(Invoice invoiceToRemove) {
		
		getInvoices().remove(invoiceToRemove);
		invoiceToRemove.setContractor(null);
	}
	
	/************************ Constructors ****************/

	public Contractor() {
	}

	public Contractor(String firstName) {
		this.firstName = firstName;
	}

	/************************ Overrides ****************/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contractor other = (Contractor) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
