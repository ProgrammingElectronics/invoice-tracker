package com.invoicetracker.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "customerImpId")
public class CustomerImp extends Customer {
	
	/************************ Field Values ****************/
	
//	@Id
//	@GeneratedValue
//	private long id;
	
	@ManyToMany
	private Collection<Contractor> contractors;
	
	@ManyToOne
	private Agency agency;
	
	@ManyToMany
	private Collection<InvoiceImp> invoices;
	
	/************************ Getters and Setters ****************/
	
//	public long getId() {
//		return id;
//	}

	public Collection<Contractor> getContractors() {
		return contractors;
	}

	public Agency getAgency() {
		return agency;
	}

	/************************ Overrides ****************/
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (id ^ (id >>> 32));
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		CustomerImp other = (CustomerImp) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}
		
}