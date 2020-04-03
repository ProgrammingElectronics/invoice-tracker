package com.invoicetracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.CustomerImp;

public interface CustomerImpRepository extends CrudRepository<CustomerImp, Long> {

}
