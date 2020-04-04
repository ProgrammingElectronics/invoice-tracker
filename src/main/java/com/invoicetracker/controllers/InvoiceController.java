package com.invoicetracker.controllers;

import java.time.LocalDate;

import javax.annotation.Resource;

import org.json.JSONException;
//the jar file for this import is on the desktop 
// source of file is found https://stackoverflow.com/questions/8997598/importing-json-into-an-eclipse-project
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoicetracker.models.Invoice;
import com.invoicetracker.repositories.InvoiceRepository;

@CrossOrigin
@Controller
public class InvoiceController {

	@Resource
	private InvoiceRepository invoiceRepo;
	
	@RequestMapping("submit-invoice")
	private void createNewInvoice(@RequestBody String body) throws JSONException {
		JSONObject newInvoice = new JSONObject(body);
		String dateOfInvoice = newInvoice.getString("invoiceDate");
		LocalDate localDate = LocalDate.parse(dateOfInvoice);
		invoiceRepo.save(new Invoice(localDate));
	}
}
