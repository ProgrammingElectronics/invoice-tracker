package com.invoicetracker.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invoicetracker.models.Contractor;

@Repository
public interface ContractorRepository extends CrudRepository<Contractor, Long> {

}
