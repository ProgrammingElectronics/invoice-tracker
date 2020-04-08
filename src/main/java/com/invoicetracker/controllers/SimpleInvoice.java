package com.invoicetracker.controllers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SimpleInvoice {

	@Id
	@GeneratedValue
	private long id;
	private String contractorName;
	private String date;
	private String invoiceNumber;
	private String amountDue;
	
	public void simpleInvoice(Long id, String contractorName, String date, String invoiceNumber, String amountDue) {
		this.contractorName = contractorName;
		this.date = date;
		this.invoiceNumber = invoiceNumber;
		this.amountDue = amountDue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	public String getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(String amountDue) {
		this.amountDue = amountDue;
		
	}

}
