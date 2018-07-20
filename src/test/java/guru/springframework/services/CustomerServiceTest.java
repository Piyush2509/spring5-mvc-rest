package guru.springframework.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CustomerRepository;

/**
 * Created by piyush.b.kumar on Jul 19, 2018
 */
public class CustomerServiceTest {

	CustomerService customerService;

	@Mock
	CustomerRepository customerRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
	}

	@Test
	public void testGetAllCustomers() throws Exception {
		// given//given
		Customer customer1 = new Customer();
		customer1.setId(1l);
		customer1.setFirstname("Michale");
		customer1.setLastname("Weston");

		Customer customer2 = new Customer();
		customer2.setId(2l);
		customer2.setFirstname("Sam");
		customer2.setLastname("Axe");

		when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

		// when
		List<CustomerDTO> customerDTOs = customerService.getAllCustomers();

		// then
		assertEquals(2, customerDTOs.size());
	}

	@Test
	public void testGetCustomerById() throws Exception {
		// given
		Customer customer = new Customer();
		customer.setId(1l);
		customer.setFirstname("Michale");
		customer.setLastname("Weston");

		when(customerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(customer));

		// when
		CustomerDTO customerDTO = customerService.getCustomerById(1L);

		// then
		assertEquals("Michale", customerDTO.getFirstname());
	}

	@Test
	public void testCreateNewCustomer() throws Exception {
		// given
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstname("Jim");

		Customer savedCustomer = new Customer();
		savedCustomer.setFirstname(customerDTO.getFirstname());
		savedCustomer.setLastname(customerDTO.getLastname());
		savedCustomer.setId(1L);

		when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

		// when
		CustomerDTO savedDTO = customerService.createNewCustomer(customerDTO);

		// then
		assertEquals(customerDTO.getFirstname(), savedDTO.getFirstname());
		assertEquals("/api/v1/customers/1", savedDTO.getCustomerUrl());
	}

}
