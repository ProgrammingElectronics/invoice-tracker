package com.invoicetracker.controllers;

import org.springframework.data.repository.CrudRepository;

public interface SimpleInvoiceRepository extends CrudRepository<SimpleInvoice, Long>{

}
