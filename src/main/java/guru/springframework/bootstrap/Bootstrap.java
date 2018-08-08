package guru.springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.repositories.VendorRepository;

/**
 * Created by piyush.b.kumar on Jul 18, 2018
 */
@Component
public class Bootstrap implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final CustomerRepository customerRepository;
	private final VendorRepository vendorRepository;

	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository,
			VendorRepository vendorRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadCategories();
		loadCustomers();
		loadVendors();
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

		System.out.println("Categories Loaded = " + categoryRepository.count());
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

	private void loadVendors() {
		Vendor vendor1 = new Vendor();
		vendor1.setName("Western Tasty Fruits Ltd.");

		Vendor vendor2 = new Vendor();
		vendor2.setName("Exotic Fruits Company");

		Vendor vendor3 = new Vendor();
		vendor3.setName("Home Fruits");

		Vendor vendor4 = new Vendor();
		vendor4.setName("Fun Fresh Fruits Ltd.");

		Vendor vendor5 = new Vendor();
		vendor5.setName("Nuts for Buts Company");

		vendorRepository.save(vendor1);
		vendorRepository.save(vendor2);
		vendorRepository.save(vendor3);
		vendorRepository.save(vendor4);
		vendorRepository.save(vendor5);

		System.out.println("Vendors Loaded = " + vendorRepository.count());
	}

}
