package guru.springframework.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.repositories.CustomerRepository;

/**
 * Created by piyush.b.kumar on Jul 19, 2018
 */
@Component
public class CustomerServiceImpl implements CustomerService {

	private final CustomerMapper customerMapper;
	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository.findAll().stream().map(customer -> {
			CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
			customerDTO.setCustomerUrl("/api/v1/customer/" + customer.getId());
			return customerDTO;
		}).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		return customerRepository.findById(id).map(customerMapper::customerToCustomerDTO)
				.orElseThrow(RuntimeException::new);
	}

}
