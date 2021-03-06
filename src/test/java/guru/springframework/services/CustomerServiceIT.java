package guru.springframework.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.bootstrap.Bootstrap;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.repositories.VendorRepository;

/**
 * Created by piyush.b.kumar on Jul 20, 2018
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceIT {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	VendorRepository vendorRepository;

	CustomerService customerService;

	@Before
	public void setUp() throws Exception {
		System.out.println("Loading Customer Data");
		System.out.println(customerRepository.findAll().size());

		// setup data for testing
		Bootstrap bootstrap = new Bootstrap(categoryRepository, customerRepository, vendorRepository);
		bootstrap.run(); // load data

		customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
	}

	@Test
	public void testPatchCustomerUpdateFirstName() throws Exception {
		String updatedName = "UpdatedName";
		Long id = getCustomerIdValue();

		Customer originalCustomer = customerRepository.getOne(id);
		assertNotNull(originalCustomer);

		String originalFirstName = originalCustomer.getFirstname();
		String originalLastName = originalCustomer.getLastname();

		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstname(updatedName);

		customerService.patchCustomer(id, customerDTO);

		Customer updatedCustomer = customerRepository.findById(id).get();

		assertNotNull(updatedCustomer);
		assertEquals(updatedName, updatedCustomer.getFirstname());
		assertThat(originalFirstName, not(equalTo(updatedCustomer.getFirstname())));
		assertThat(originalLastName, equalTo(updatedCustomer.getLastname()));

	}

	@Test
	public void testPatchCustomerUpdateLastName() throws Exception {
		String updatedName = "UpdatedName";
		Long id = getCustomerIdValue();

		Customer originalCustomer = customerRepository.getOne(id);
		assertNotNull(originalCustomer);

		String originalFirstName = originalCustomer.getFirstname();
		String originalLastName = originalCustomer.getLastname();

		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setLastname(updatedName);

		customerService.patchCustomer(id, customerDTO);

		Customer updatedCustomer = customerRepository.findById(id).get();

		assertNotNull(updatedCustomer);
		assertEquals(updatedName, updatedCustomer.getLastname());
		assertThat(originalFirstName, equalTo(updatedCustomer.getFirstname()));
		assertThat(originalLastName, not(equalTo(updatedCustomer.getLastname())));

	}

	private Long getCustomerIdValue() {
		List<Customer> customers = customerRepository.findAll();
		System.out.println("Customers Found: " + customers.size());
		return customers.get(0).getId();
	}

}
