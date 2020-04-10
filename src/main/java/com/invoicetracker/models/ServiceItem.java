package com.invoicetracker.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ServiceItem {

	/************************ Field Values ****************/

	@Id
	@GeneratedValue
	private long id;

	private LocalDate dateOfService;
	private float amountDue;
	private String serviceDescription; 

	@ManyToOne
	private Invoice invoice;

	/************************ Getters and Setters ****************/

	public long getId() {
		return id;
	}

	public LocalDate getDateOfService() {
		return dateOfService;
	}
	
	public void setDateOfService(LocalDate dateOfService) {
		this.dateOfService = dateOfService;
	}
	
	public float getAmountDue() {
		return amountDue;
	}
	
	public void setAmountDue(float amountDue) {
		this.amountDue = amountDue;
	}
	
	public String getServiceDescription() {
		return serviceDescription;
	}
	
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}
	
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	/********************* Constructors ****************/

	public ServiceItem() {
	}
	
	public ServiceItem(Invoice invoice) {
		this.invoice = invoice;
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
		ServiceItem other = (ServiceItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}