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

import com.invoicetracker.Repositories.AgencyRespository;
import com.invoicetracker.Repositories.ContractorRepository;
import com.invoicetracker.models.Agency;
import com.invoicetracker.models.Contractor;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ContractorRepository contractorRepo;
	
	@Resource
	private AgencyRespository agencyRepo;

	@Test
	public void shouldSaveAndLoadContractorPayPalId() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor("firstName"));
		contractor.setPayPalId("payPalId");
		long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();

		// Assert
		assertEquals(contractor.getPayPalId(), "payPalId");

	}

	@Test
	public void shouldSaveAndLoadContractorFirstName() {
		// Arrange
		Contractor contractor = contractorRepo.save(new Contractor("firstName"));
		long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();

		// Assert
		assertEquals(contractor.getFirstName(), "firstName");
	}

	@Test
	public void shouldGenrateContractorId() {
		//Arrange
		Contractor contractor = contractorRepo.save(new Contractor("firstName"));
		long contractorId = contractor.getId();
		
		//Act
		entityManager.flush();
		entityManager.clear();
		
		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();
		
		//Assert
		assertThat(contractor.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadAgencyBusinessName() {
		
		// Arrange
		Agency agency = agencyRepo.save(new Agency("businessName"));
		Long agencyId = agency.getId();
		
		//Act
		entityManager.flush();
		entityManager.clear();
		
		Optional<Agency> result = agencyRepo.findById(agencyId);
		agency = result.get();
		
		//Assert
		assertEquals(agency.getBusinessName(), "businessName");
	}

	@Test
	public void shouldGenerateAgencyId() {
		
		// Arrange
		Agency agency = agencyRepo.save(new Agency("businessName"));
		Long agencyId = agency.getId();
		
		//Act
		entityManager.flush();
		entityManager.clear();
		
		Optional<Agency> result = agencyRepo.findById(agencyId);
		agency = result.get();
		
		//Assert
		assertThat(agency.getId(), is(greaterThan(0L)));
	}
}
