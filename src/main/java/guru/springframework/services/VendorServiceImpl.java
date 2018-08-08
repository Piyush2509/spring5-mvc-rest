package guru.springframework.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import guru.springframework.api.v1.mapper.VendorMapper;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.api.v1.model.VendorListDTO;
import guru.springframework.controllers.v1.CustomerController;
import guru.springframework.controllers.v1.VendorController;
import guru.springframework.domain.Vendor;
import guru.springframework.exceptions.ResourceNotFoundException;
import guru.springframework.repositories.VendorRepository;

/**
 * Created by piyush.b.kumar on Jul 24, 2018
 */
@Component
public class VendorServiceImpl implements VendorService {

	private final VendorMapper vendorMapper;
	private final VendorRepository vendorRepository;

	public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
		this.vendorMapper = vendorMapper;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public VendorDTO getVendorById(Long id) {
		return vendorRepository.findById(id).map(vendorMapper::vendorToVendorDTO).map(vendorDTO -> {
			vendorDTO.setVendorUrl(getVendorUrl(id));
			return vendorDTO;
		}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public VendorListDTO getAllVendors() {
		List<VendorDTO> vendorDTOs = vendorRepository.findAll().stream().map(vendor -> {
			VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
			vendorDTO.setVendorUrl(getVendorUrl(vendor.getId()));
			return vendorDTO;
		}).collect(Collectors.toList());

		return new VendorListDTO(vendorDTOs);
	}

	@Override
	public VendorDTO createNewVendor(VendorDTO vendorDTO) {
		return saveAndReturnDTO(vendorMapper.vendorDTOToVendor(vendorDTO));
	}

	@Override
	public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {
		Vendor vendorToSave = vendorMapper.vendorDTOToVendor(vendorDTO);
		vendorToSave.setId(id);
		return saveAndReturnDTO(vendorToSave);
	}

	@Override
	public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
		return vendorRepository.findById(id).map(vendor -> {
			if (vendorDTO.getName() != null) {
				vendor.setName(vendorDTO.getName());
			}

			return saveAndReturnDTO(vendor);
		}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteVendorById(Long id) {
		vendorRepository.deleteById(id);
	}

	private VendorDTO saveAndReturnDTO(Vendor vendor) {
		Vendor savedVendor = vendorRepository.save(vendor);
		VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(savedVendor);
		returnDTO.setVendorUrl(getVendorUrl(savedVendor.getId()));
		return returnDTO;
	}

	private String getVendorUrl(Long id) {
		return VendorController.BASE_URL + "/" + id;
	}

}
