package com.invoicetracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.InvoiceImp;

public interface InvoiceImpRepository extends CrudRepository<InvoiceImp, Long> {

}
