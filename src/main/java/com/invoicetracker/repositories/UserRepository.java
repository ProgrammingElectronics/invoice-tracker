package com.invoicetracker.repositories;

import com.invoicetracker.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
