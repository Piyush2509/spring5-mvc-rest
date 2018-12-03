package guru.springframework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.domain.Vendor;

/**
 * Created by piyush.b.kumar on Jul 24, 2018
 */
public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
