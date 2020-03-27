package com.invoicetracker.models;


public abstract class Customer {
	
	/************************ Field Values ****************/

	private String customerName;
	private int accountNumber;


	/************************ Getters and Setters ****************/
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}