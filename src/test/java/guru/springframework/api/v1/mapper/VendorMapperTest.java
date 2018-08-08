package guru.springframework.api.v1.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Vendor;

/**
 * Created by piyush.b.kumar on Jul 24, 2018
 */
public class VendorMapperTest {

	private static final String NAME = "Home Fruits";

	VendorMapper vendorMapper = VendorMapper.INSTANCE;

	@Test
	public void testVendorToVendorDTO() throws Exception {
		// given
		Vendor vendor = new Vendor();
		vendor.setName(NAME);

		// when
		VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);

		// then
		assertEquals(NAME, vendorDTO.getName());
	}

	@Test
	public void testVendorDTOToVendor() throws Exception {
		// given
		VendorDTO vendorDTO = new VendorDTO();
		vendorDTO.setName(NAME);

		// when
		Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);

		// then
		assertEquals(NAME, vendor.getName());
	}

}
