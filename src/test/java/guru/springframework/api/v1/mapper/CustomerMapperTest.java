package guru.springframework.api.v1.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.domain.Customer;

/**
 * Created by piyush.b.kumar on Jul 19, 2018
 */
public class CustomerMapperTest {

	private static final String FIRST_NAME = "Piyush";
	private static final String LAST_NAME = "Kumar";
	private static final long ID = 1L;

	CustomerMapper customerMapper = CustomerMapper.INSTANCE;

	@Test
	public void testCustomerToCustomerDTO() throws Exception {
		// given
		Customer customer = new Customer();
		customer.setFirstname(FIRST_NAME);
		customer.setLastname(LAST_NAME);
		customer.setId(ID);

		// when
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

		// then
		assertEquals(FIRST_NAME, customerDTO.getFirstname());
		assertEquals(LAST_NAME, customerDTO.getLastname());
	}

}
