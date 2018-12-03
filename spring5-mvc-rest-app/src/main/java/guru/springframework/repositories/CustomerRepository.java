package guru.springframework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.domain.Customer;

/**
 * Created by piyush.b.kumar on Jul 19, 2018
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
