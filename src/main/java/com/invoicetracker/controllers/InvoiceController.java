package com.invoicetracker.controllers;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
//the jar file for this import is on the desktop 
// source of file is found https://stackoverflow.com/questions/8997598/importing-json-into-an-eclipse-project
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.invoicetracker.models.Invoice;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.CustomerRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@CrossOrigin
@Controller
public class InvoiceController {

	@Resource
	private InvoiceRepository invoiceRepo;
	
	@Resource
	private ServiceItemRepository serviceItemRepo;

	@Resource
	private ContractorRepository contractorItemRepo;
	
	@RequestMapping("submit-invoice")
	private void createNewInvoice(@RequestBody String body) throws JSONException {
		
		/* Create the invoice */
		JSONObject newInvoice = new JSONObject(body);
		
		String dateOfInvoice = newInvoice.getJSONObject("invoiceNumbersJson").getString("invoiceDate");
		LocalDate localDate = LocalDate.parse(dateOfInvoice);
		Invoice invoice = new Invoice(localDate);
			
		int invoiceNumber = newInvoice.getJSONObject("invoiceNumbersJson").getInt("invoiceNumber");
		invoice.setInvoiceNumber(invoiceNumber);		
		invoiceRepo.save(invoice);
		
		/* Add Service Items */
		JSONArray serviceItemsArray = newInvoice.getJSONArray("invoiceArray");
		
		for(int i = 0; i < serviceItemsArray.length(); i++) {
			
			JSONObject aServiceItem = (JSONObject) serviceItemsArray.get(2);
			String serviceDate = aServiceItem.getString("serviceDate");
			LocalDate localServiceDate = LocalDate.parse(serviceDate);
			ServiceItem newServiceItem = new ServiceItem(localServiceDate, invoice);
			serviceItemRepo.save(newServiceItem);
		}
		
		contractorItemRepo.findById(27L).get().addInvoice(invoice);

	}
			
}
