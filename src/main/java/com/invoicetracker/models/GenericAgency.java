package com.invoicetracker.models;

public class GenericAgency extends User {
	
	/************************ Field Values ****************/
	
	private GenericContractor contractors;
	private GenericCustomer customers;
	
	/************************ Getters and Setters ****************/
	
	public GenericContractor getContractors() {
		return contractors;
	}
	
	public void setContractors(GenericContractor contractors) {
		this.contractors = contractors;
	}
	
	public GenericCustomer getCustomers() {
		return customers;
	}
	
	public void setCustomers(GenericCustomer customers) {
		this.customers = customers;
	}

}
