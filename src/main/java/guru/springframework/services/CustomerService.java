package guru.springframework.services;

import java.util.List;

import guru.springframework.api.v1.model.CustomerDTO;

/**
 * Created by piyush.b.kumar on Jul 19, 2018
 */
public interface CustomerService {

	List<CustomerDTO> getAllCustomers();

	CustomerDTO getCustomerById(Long id);

	CustomerDTO createNewCustomer(CustomerDTO customerDTO);

	CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

	CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

	void deleteCustomerById(Long id);

}
