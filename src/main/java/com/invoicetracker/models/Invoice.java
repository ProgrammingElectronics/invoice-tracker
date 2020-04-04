package com.invoicetracker.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Invoice {

	/************************ Field Values ****************/

	@Id
	@GeneratedValue
	private long id;
	
	private int invoiceNumber;
	private LocalDate dateOfInvoice;
	private boolean isPaid;
	private float totalAmountDue;
	
	@ManyToOne
	Contractor contractor;

	@ManyToOne
	Agency agency;

	@OneToMany
	private Collection<ServiceItem> serviceItems;

	/************************ Getters and Setter ****************/
	public long getId() {
		return id;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public LocalDate getDateOfInvoice() {
		return dateOfInvoice;
	}

	public void setDateOfInvoice(LocalDate dateOfInvoice) {
		this.dateOfInvoice = dateOfInvoice;
	}

	public float getTotalAmountDue() {
		return totalAmountDue;
	}
	
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


	public Invoice() {
	}

	public Invoice(LocalDate dateOfInvoice) {
		this.dateOfInvoice = dateOfInvoice;
	}

	public Invoice(LocalDate dateOfInvoice, ServiceItem...serviceItems) {
		this.dateOfInvoice = dateOfInvoice;
		this.serviceItems = new HashSet<>(Arrays.asList(serviceItems));
	}
	/************************ Methods ****************/
	
	public void addServiceItem(ServiceItem serviceItem) {
		this.serviceItems.add(serviceItem);
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
		Invoice other = (Invoice) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
