package com.invoicetracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.Agency;

public interface AgencyRepository extends CrudRepository<Agency, Long> {

}
