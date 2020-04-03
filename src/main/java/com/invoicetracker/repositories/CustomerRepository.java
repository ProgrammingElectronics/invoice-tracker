package com.invoicetracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
