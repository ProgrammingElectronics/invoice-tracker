package com.invoicetracker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.invoicetracker.Repositories.ContractorRepository;
import com.invoicetracker.models.Contractor;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingsTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private ContractorRepository contractorRepo;
	
	@Test
	public void shouldSaveAndLoadContractor() {
		//Arrange
		Contractor contractor = contractorRepo.save(new Contractor("firstName"));
		long contractorId = contractor.getId();
		
		//Act
		entityManager.flush();
		entityManager.clear();
		
		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();
		
		
		System.out.println("***************" + contractor.getFirstName());
				
		//Assert
		assertEquals(contractor.getFirstName(), "firstName");

	}

}
