package com.invoicetracker.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "customerImpId")
public class CustomerImp extends Customer {

	/************************ Field Values ****************/

	@ManyToMany
	private Collection<Contractor> contractors;

	@ManyToOne
	private Agency agency;

	@ManyToMany
	private Collection<ServiceItem> ServiceItems;

	/************************ Getters and Setters ****************/

	public Collection<Contractor> getContractors() {
		return contractors;
	}

	public Agency getAgency() {
		return agency;
	}

	public Collection<ServiceItem> getServiceItems() {
		return ServiceItems;
	}

	/************************ Constructors ****************/

	public CustomerImp() {
	}

	public CustomerImp(String customerName) {
		super(customerName);
	}

	public CustomerImp(String customerName, ServiceItem... serviceItems) {
		super(customerName);
		this.ServiceItems = new HashSet<>(Arrays.asList(serviceItems));
	}

}