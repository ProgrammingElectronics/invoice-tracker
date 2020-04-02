package com.invoicetracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
