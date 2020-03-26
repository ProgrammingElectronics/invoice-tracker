package com.invoicetracker.models;

public class GenericContractor extends User{
	
	/************************ Field Values ****************/
	private GenericAgency agency;
	private GenericCustomer customers;
	private String payPalId;
	
	
	/************************ Getters and Setters ****************/
	public GenericAgency getAgency() {
		return agency;
	}
	
	public void setAgency(GenericAgency agency) {
		this.agency = agency;
	}
	
	public GenericCustomer getCustomers() {
		return customers;
	}
	
	public void setCustomers(GenericCustomer customers) {
		this.customers = customers;
	}
	
	public String getPayPalId() {
		return payPalId;
	}
	
	public void setPayPalId(String payPalId) {
		this.payPalId = payPalId;
	}
	                                  
}
