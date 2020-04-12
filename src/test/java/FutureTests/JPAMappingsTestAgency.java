package FutureTests;

import java.time.LocalDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.invoicetracker.models.Agency;
import com.invoicetracker.models.Contractor;
import com.invoicetracker.models.Customer;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.AgencyRepository;
import com.invoicetracker.repositories.ContractorRepository;
import com.invoicetracker.repositories.CustomerRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
class JPAMappingsTestAgency {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ContractorRepository contractorRepo;
	
	@Resource
	private AgencyRepository agencyRepo;
	
	@Test
	public void shouldSaveAndLoadAgencyBusinessName() {

		// Arrange
		Agency agency = agencyRepo.save(new Agency("businessName"));
		Long agencyId = agency.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Agency> result = agencyRepo.findById(agencyId);
		agency = result.get();

		// Assert
		assertEquals(agency.getBusinessName(), "businessName");
	}

	@Test
	public void shouldGenerateAgencyId() {

		// Arrange
		Agency agency = agencyRepo.save(new Agency("businessName"));
		Long agencyId = agency.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Agency> result = agencyRepo.findById(agencyId);
		agency = result.get();

		// Assert
		assertThat(agency.getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldEstablishContractorToAgencyRelationship() {
		// Arrange
		Agency agency = agencyRepo.save(new Agency("test"));
		Contractor contractor = contractorRepo.save(new Contractor("testContractor", agency));

		Long contractorId = contractor.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Contractor> result = contractorRepo.findById(contractorId);
		contractor = result.get();

		// Assert
		assertEquals(contractor.getAgency(), agency);

	}

	@Test
	public void shouldEstablishAgencyToContractorRelationship() {
		// Arrange
		Contractor contractorOne = contractorRepo.save(new Contractor("testContractorOne"));
		Contractor contractorTwo = contractorRepo.save(new Contractor("testContractorTwo"));
		Agency agency = agencyRepo.save(new Agency("test", contractorOne, contractorTwo));
		Long agencyId = agency.getId();

		// Act
		entityManager.flush();
		entityManager.clear();

		Optional<Agency> result = agencyRepo.findById(agencyId);
		agency = result.get();

		// Assert
		assertThat(agency.getContractors(), containsInAnyOrder(contractorOne, contractorTwo));

	}


}
