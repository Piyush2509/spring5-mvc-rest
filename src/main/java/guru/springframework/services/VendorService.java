package guru.springframework.services;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.api.v1.model.VendorListDTO;

/**
 * Created by piyush.b.kumar on Jul 24, 2018
 */
public interface VendorService {

	VendorDTO getVendorById(Long id);

	VendorListDTO getAllVendors();

	VendorDTO createNewVendor(VendorDTO vendorDTO);

	VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

	VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

	void deleteVendorById(Long id);

}
