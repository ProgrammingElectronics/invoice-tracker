package com.invoicetracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.ServiceItem;

public interface ServiceItemRepository extends CrudRepository<ServiceItem, Long> {

}
