package com.invoicetracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class InvoiceImp extends Invoice {
	
	/************************ Field Values ****************/
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	Contractor contractor;
	
	@ManyToOne
	Agency agency;
	
	/************************ Getters and Setter ****************/
	
	public Contractor getContractor() {
		return contractor;
	}

	public Agency getAgency() {
		return agency;
	}
	
	public long getId() {
		return id;
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
		InvoiceImp other = (InvoiceImp) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
