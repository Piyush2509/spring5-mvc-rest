package guru.springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;

/**
 * Created by piyush.b.kumar on Jul 18, 2018
 */
@Component
public class Bootstrap implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final CustomerRepository customerRepository;

	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadCategories();
		loadCustomers();
	}

	private void loadCategories() {
		Category fruits = new Category();
		fruits.setName("Fruits");

		Category dried = new Category();
		dried.setName("Dried");

		Category fresh = new Category();
		fresh.setName("Fresh");

		Category exotic = new Category();
		exotic.setName("Exotic");

		Category nuts = new Category();
		nuts.setName("Nuts");

		categoryRepository.save(fruits);
		categoryRepository.save(dried);
		categoryRepository.save(fresh);
		categoryRepository.save(exotic);
		categoryRepository.save(nuts);

		System.out.println("Data Loaded = " + categoryRepository.count());
	}

	private void loadCustomers() {
		Customer customer1 = new Customer();
		customer1.setId(1L);
		customer1.setFirstname("Michale");
		customer1.setLastname("Weston");

		Customer customer2 = new Customer();
		customer2.setId(2L);
		customer2.setFirstname("Sam");
		customer2.setLastname("Axe");

		customerRepository.save(customer1);
		customerRepository.save(customer2);

		System.out.println("Customers Loaded = " + customerRepository.count());
	}

}
