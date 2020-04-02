package com.invoicetracker;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.invoicetracker.repositories.CustomerImpRepository;

@Component
public class Populator implements CommandLineRunner {

	@Resource
	CustomerImpRepository customerRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
	}

	
	
}
