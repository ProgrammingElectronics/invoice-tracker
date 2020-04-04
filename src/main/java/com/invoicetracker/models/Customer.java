package com.invoicetracker.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	/************************ Field Values ****************/

	@Id
	@GeneratedValue
	private long id;
	
	private String customerName;
	private int accountNumber;
	
	@ManyToMany
	private Collection<Contractor> contractors;

	@ManyToOne
	private Agency agency;

	@OneToMany
	private Collection<ServiceItem> serviceItems;

	/************************ Getters and Setters ****************/

	public long getId() {
		return id;
	}
	
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
	public Collection<Contractor> getContractors() {
		return contractors;
	}

	public Agency getAgency() {
		return agency;
	}

	public Collection<ServiceItem> getServiceItems() {
		return serviceItems;
	}

	/************************ Constructors ****************/

	public Customer() {
	}

	public Customer(String customerName) {
		this.customerName = customerName;
	}

	public Customer(String customerName, ServiceItem ... serviceItems) {
		this.customerName = customerName;
		this.serviceItems = new HashSet<>(Arrays.asList(serviceItems));
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
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}

}