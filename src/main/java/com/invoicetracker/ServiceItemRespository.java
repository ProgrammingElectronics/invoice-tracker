package com.invoicetracker;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.ServiceItem;

public interface ServiceItemRespository extends CrudRepository<ServiceItem, Long> {

}
