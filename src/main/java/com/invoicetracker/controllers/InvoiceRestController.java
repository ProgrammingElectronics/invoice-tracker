package com.invoicetracker.controllers;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class InvoiceRestController {

	@Resource
	private SimpleInvoiceRepository sInvoiceRepo;
	
	@RequestMapping("submit")
	private void createNewSimpleInvoice(@RequestBody String body) throws JSONException {
		JSONObject newSimpleInvoice = new JSONObject(body);
		String contractorName = newSimpleInvoice.getJSONObject("contractorJson").getString("contractorName");
		String date = newSimpleInvoice.getJSONObject("invoiceNumbersJson").getString("invoiceDate");
		String invoiceNumber = newSimpleInvoice.getJSONObject("invoiceNumbersJson").getString("invoiceNumber");
		//JSONArray amountDue = newSimpleInvoice.getJSONArray("invoiceArray");
		
		SimpleInvoice invoice = new SimpleInvoice();
		invoice.setContractorName(contractorName);
		invoice.setDate(date);
		invoice.setInvoiceNumber(invoiceNumber);
		//invoice.setAmountDue(amountDue);
		sInvoiceRepo.save(invoice);
		}
	
	
//	{"contractorJson":
//		{"contractorName":"jason",
//		"contractorAddress":"",
//		"contractorPhone":""},
//	"invoiceNumbersJson":
//		{"invoiceNumber":"990009",
//			"invoiceDate":"today",
//			"invoiceTerm":""},
//	"agencyJson":
//		{"agencyName":"",
//		"agencyAddress":"",
//		"agencyPhone":""},
	
//	String hourlyRate = newSimpleInvoice.getJSONArray("invoiceArray").getJSONObject("innerInvoiceId"[WRONG]).getString("hourlyRate");
	
//	"invoiceArray":[
//		 {"innerInvoiceId":"1",
//			 "clientName":"",
//			 "serviceName":"",
//			 "serviceDate":"",
//			 "serviceTime":"",
//			 "hourlyRate":"",
//			 "amountDue":""}
//		 ]}
}
	
	
	

//	@RequestMapping("submit")
//	@ResponseBody
//	private SimpleInvoice createNewSimpleInvoice(@RequestBody SimpleInvoice body) throws JSONException {
//		return sInvoiceRepo.save(body);
//	}