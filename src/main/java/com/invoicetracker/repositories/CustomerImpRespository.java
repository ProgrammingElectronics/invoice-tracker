package com.invoicetracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.CustomerImp;

public interface CustomerImpRespository extends CrudRepository<CustomerImp, Long> {

}
