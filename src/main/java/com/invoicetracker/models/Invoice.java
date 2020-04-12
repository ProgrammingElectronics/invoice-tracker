package com.invoicetracker.models;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Invoice {

	/************************ Field Values ****************/

	@Id
	@GeneratedValue
	private long id;

	private LocalDate dateOfInvoice;
	private int invoiceNumber;
	private float totalAmountDue;
	private String invoiceNote;
	private boolean isPaid;
	private boolean isSent;

	@JsonIgnore
	@ManyToOne
	private Contractor contractor;

	@OneToMany(mappedBy = "invoice")
	private Collection<ServiceItem> serviceItems;

	/************************ Getters and Setter ****************/
	public long getId() {
		return id;
	}

	public LocalDate getDateOfInvoice() {
		return dateOfInvoice;
	}

	public void setDateOfInvoice(LocalDate dateOfInvoice) {
		this.dateOfInvoice = dateOfInvoice;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public float getTotalAmountDue() {
		return totalAmountDue;
	}

	public void setTotalAmountDue(float totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}

	public String getInvoiceNote() {
		return invoiceNote;
	}

	public void setInvoiceNote(String invoiceNote) {
		this.invoiceNote = invoiceNote;
	}

	public boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public boolean getIsSent() {
		return isSent;
	}
	
	public void setIsSent(boolean isSent) {
		this.isSent = isSent;
	}
	
	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public Collection<ServiceItem> getServiceItems() {
		return serviceItems;
	}

	public void setServiceItems(Collection<ServiceItem> serviceItems) {
		this.serviceItems = serviceItems;
	}

	/************************ Constructors ****************/

	public Invoice() {
	}

	public Invoice(Contractor contractor) {
		
		this.contractor = contractor;
		this.contractor.incrementCurrentInvoiceNumber();
		this.invoiceNumber = contractor.getCurrentInvoiceNumber();
	}

	/************************ Methods ****************/

	public void removeServiceItem(ServiceItem serviceItemToRemove) {

		getServiceItems().remove(serviceItemToRemove);
		serviceItemToRemove.setInvoice(null);
	}

	public String getTotalAmountDueAsCurrencyString() {

		float amount = calculateTotalAmountDueFromAllServiceItemsOnInvoice();
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		String currency = format.format(amount);
		// TODO: Requires Code Review
		// I am auto down casting here, format expects a double...Is that bad?

		return currency;
	}

	public float calculateTotalAmountDueFromAllServiceItemsOnInvoice() {

		float runningTotal = 0;

		for (ServiceItem item : this.serviceItems) {
			runningTotal += item.getAmountDue();
		}

		return runningTotal;
	}

	// TODO This function is an abomination and needs fixed.
	public String getCustomerNamePreviewAsString() {

		/* Test and then remove this */
		// ArrayList<ServiceItem> serviceItemsArray = new
		// ArrayList<>(this.serviceItems);
		String customerNames = "";

		int count = 0;
		for (ServiceItem serviceItem : serviceItems) {

			if (count == 0) {
				customerNames += serviceItem.getServiceDescription();
			}
			if (count == 1) {
				customerNames += ", " + serviceItem.getServiceDescription();
			}
			if (count == 2) {
				customerNames += " ... plus " + (Math.abs(serviceItems.size() - 2)) + " more";
			}

			count++;
		}

		return customerNames;
	}
	
	public Object showPaymentStatus() {
		
		String currentPaymentStatus;
		
		if(isPaid) {
			currentPaymentStatus = "Paid";	
		} else if(isSent) {
			currentPaymentStatus = "Sent";
		} else {
			currentPaymentStatus = "Not sent";
		}
		
		return currentPaymentStatus;
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
		Invoice other = (Invoice) obj;
		if (id != other.id)
			return false;
		return true;
	}



}