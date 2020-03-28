package com.invoicetracker.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Invoice {

	/************************ Field Values ****************/
	
	@Id
	@GeneratedValue
	private long id;
	private int invoiceNumber;
	private LocalDate dateOfInvoice;
	private boolean isPaid;
	private float totalAmountDue;
	
	
//	private LocalDate dateOfService;
//	private float payRateOfAService;
//	private float serviceHours;
//	private float amountDue;
	
	/************************ Getters and Setters ****************/
	
	public long getId() {
		return id;
	}
	
//	public LocalDate getDateOfService() {
//		return dateOfService;
//	}
//	
//	public void setDateOfService(LocalDate dateOfService) {
//		this.dateOfService = dateOfService;
//	}
//	
//	public float getPayRateOfAService() {
//		return payRateOfAService;
//	}
//	
//	public void setPayRateOfAService(float payRateOfAService) {
//		this.payRateOfAService = payRateOfAService;
//	}
//	
//	public float getServiceHours() {
//		return serviceHours;
//	}
//	
//	public void setServiceHours(float serviceHours) {
//		this.serviceHours = serviceHours;
//	}
//	
//	public float getAmountDue() {
//		return amountDue;
//	}
//	
//	public void setAmountDue(float amountDue) {
//		this.amountDue = amountDue;
//	}
	
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
	
	public void setTotalAmountDue(float totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}
	
	/************************ Constructors ****************/
	
	protected Invoice() {}
	
	protected Invoice(LocalDate dateOfInvoice) {
		this.dateOfInvoice = dateOfInvoice;
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