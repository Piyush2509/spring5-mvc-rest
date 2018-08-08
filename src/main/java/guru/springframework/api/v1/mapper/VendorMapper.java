package guru.springframework.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Vendor;

/**
 * Created by piyush.b.kumar on Jul 24, 2018
 */
@Mapper
public interface VendorMapper {

	VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

	VendorDTO vendorToVendorDTO(Vendor vendor);

	Vendor vendorDTOToVendor(VendorDTO vendorDTO);

}
