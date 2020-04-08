package com.invoicetracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
