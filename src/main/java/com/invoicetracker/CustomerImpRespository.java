package com.invoicetracker;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.CustomerImp;

public interface CustomerImpRespository extends CrudRepository<CustomerImp, Long> {

}
