package com.invoicetracker;

import org.json.JSONObject;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.json.simple.JSONObject;
import com.invoicetracker.controllers.InvoiceController;

public class InvoiceControllerTest {

	@InjectMocks
	private InvoiceController underTest;
	
	private JSONObject testInvoice = new JSONObject()
	testInvoice = "{\"contractorJson\":{\"contractorName\":\"Test Cont\",\"contractorAddress\":\"Test Cont Address\",\"contractorPhone\":\"0987654321\"},\"invoiceNumbersJson\":{\"invoiceNumber\":\"3145276\",\"invoiceDate\":\"2019-12-29\",\"invoiceTerm\":\"14days\"},\"agencyJson\":{\"agencyName\":\"Test Agency Name\",\"agencyAddress\":\"Test Agency Address\",\"agencyPhone\":\"1234567890\"},\"invoiceArray\":[{\"innerInvoiceId\":\"1\",\"clientName\":\"george\",\"serviceName\":\"adf\",\"serviceDate\":\"2020-04-01\",\"serviceTime\":\"1\",\"hourlyRate\":\"5\",\"amountDue\":\"25\"},{\"innerInvoiceId\":\"2\",\"clientName\":\"heffa\",\"serviceName\":\"tooter\",\"serviceDate\":\"2019-12-31\",\"serviceTime\":\"2\",\"hourlyRate\":\"10\",\"amountDue\":\"50\"},{\"innerInvoiceId\":\"14\",\"clientName\":\"bobo\",\"serviceName\":\"paint\",\"serviceDate\":\"2020-01-01\",\"serviceTime\":\"3\",\"hourlyRate\":\"15\",\"amountDue\":\"75\"}]}";
	
	
	@Test
	public void shouldParseOutContractorName() {
		//arrange
		
		
		//act
		
		
		//assert
	}
	
	@Test
	public void shouldParseOutContractorAddress() {
		//arrange
		
		
		//act
		
		
		//assert
	}
	
	@Test
	public void shouldParseOutContractorPhone() {
		//arrange
		
		
		//act
		
		
		//assert
	}
	
	@Test
	public void shouldParseOutInvoiceNumbers() {
		//arrange
		
		
		//act
		
		
		//assert
	}
	
	@Test
	public void shouldParseOutAgencyInfo() {
		//arrange
		
		
		//act
		
		
		//assert
	}
}























