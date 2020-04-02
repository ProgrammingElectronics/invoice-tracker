package com.invoicetracker.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InvoiceAbs {

	/************************ Field Values ****************/

	@Id
	@GeneratedValue
	private long id;
	
	private int invoiceNumber;
	private LocalDate dateOfInvoice;
	private boolean isPaid;
	private float totalAmountDue;

	/************************ Getters and Setters ****************/

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

	/************************ Constructors ****************/

	protected InvoiceAbs() {
	}

	protected InvoiceAbs(LocalDate dateOfInvoice) {
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
		InvoiceAbs other = (InvoiceAbs) obj;
		if (id != other.id)
			return false;
		return true;
	}

}