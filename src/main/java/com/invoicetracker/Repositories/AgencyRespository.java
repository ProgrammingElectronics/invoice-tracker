package com.invoicetracker.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.Agency;

public interface AgencyRespository extends CrudRepository<Agency, Long> {

}
