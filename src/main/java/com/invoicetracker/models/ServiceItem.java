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

	@ManyToOne
	private Invoice invoice;

	@ManyToOne
	private Customer customer;

	private LocalDate dateOfService;
	private float hourlyPayRate;
	private float serviceHours;
	private float amountDue;

	/************************ Getters and Setters ****************/

	public long getId() {
		return id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Customer getCustomers() {
		return customer;
	}

	public void setCustomers(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getDateOfService() {
		return dateOfService;
	}

	public void setDateOfService(LocalDate dateOfService) {
		this.dateOfService = dateOfService;
	}

	public float getPayRateOfAService() {
		return hourlyPayRate;
	}

	public void setPayRateOfAService(float payRateOfAService) {
		this.hourlyPayRate = payRateOfAService;
	}

	public float getServiceHours() {
		return serviceHours;
	}

	public void setServiceHours(float serviceHours) {
		this.serviceHours = serviceHours;
	}

	public float getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(float amountDue) {
		this.amountDue = amountDue;
	}

	/********************* Constructors ****************/

	public ServiceItem() {
	}

	public ServiceItem(LocalDate dateOfService) {
		this.dateOfService = dateOfService;
	}

	public ServiceItem(LocalDate dateOfService, Invoice invoice) {
		this.dateOfService = dateOfService;
		this.invoice = invoice;
	}

	public ServiceItem(LocalDate dateOfService, Customer customer) {
		this.dateOfService = dateOfService;
		this.customer = customer;
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
