package com.invoicetracker.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


public abstract class Invoice {

	/************************ Field Values ****************/
	
	private LocalDate dateOfService;
	private float payRateOfAService;
	private float serviceHours;
	private CustomerImp customers;
	private float amountDue;
	private int invoiceNumber;
	private boolean isPaid;
	
	/************************ Getters and Setters ****************/
	
	public LocalDate getDateOfService() {
		return dateOfService;
	}
	
	public void setDateOfService(LocalDate dateOfService) {
		this.dateOfService = dateOfService;
	}
	
	public float getPayRateOfAService() {
		return payRateOfAService;
	}
	
	public void setPayRateOfAService(float payRateOfAService) {
		this.payRateOfAService = payRateOfAService;
	}
	
	public float getServiceHours() {
		return serviceHours;
	}
	
	public void setServiceHours(float serviceHours) {
		this.serviceHours = serviceHours;
	}
	
	public CustomerImp getCustomers() {
		return customers;
	}
	
	public void setCustomers(CustomerImp customers) {
		this.customers = customers;
	}
	
	public float getAmountDue() {
		return amountDue;
	}
	
	public void setAmountDue(float amountDue) {
		this.amountDue = amountDue;
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
	
}