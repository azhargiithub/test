package com.altaf.util;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.altaf.dto.AddressDTO;
import com.altaf.dto.CustomerDTO;
import com.altaf.entity.Address;
import com.altaf.entity.Customer;

public class ConverterUtils {

	public static CustomerDTO convertCustomerToDTO(Customer customer) {
		CustomerDTO dto = new CustomerDTO();
		dto.setFirstName(customer.getFirstName());
		dto.setLastName(customer.getLastName());
		dto.setCustomerId(customer.getCustomerId());
		dto.setAge(customer.getAge());
		dto.setSpendingLimit(customer.getSpendingLimit());
		dto.setMobileNumber(customer.getMobileNumber());

		List<AddressDTO> addressDTOList = Optional.ofNullable(customer.getAddress())
			    .map(addressList -> addressList.stream()
			            .map(ConverterUtils::convertAddressToDTO)
			            .collect(Collectors.toList()))
			        .orElse(Collections.emptyList());
		dto.setAddress(addressDTOList);

		return dto;
	}

	public static AddressDTO convertAddressToDTO(Address address) {
		AddressDTO dto = new AddressDTO();
		dto.setType(address.getType());
		dto.setAddress1(address.getAddress1());
		dto.setAddress2(address.getAddress2());
		dto.setCity(address.getCity());
		dto.setState(address.getState());
		dto.setZipCode(address.getZipCode());
		return dto;
	}

	public static Customer convertDTOToCustomer(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.setFirstName(dto.getFirstName());
		customer.setLastName(dto.getLastName());
		customer.setCustomerId(dto.getCustomerId());
		customer.setAge(dto.getAge());
		customer.setSpendingLimit(dto.getSpendingLimit());
		customer.setMobileNumber(dto.getMobileNumber());

		return customer;
	}

	public static Address convertDTOToAddress(AddressDTO dto) {
		Address address = new Address();
		address.setType(dto.getType());
		address.setAddress1(dto.getAddress1());
		address.setAddress2(dto.getAddress2());
		address.setCity(dto.getCity());
		address.setState(dto.getState());
		address.setZipCode(dto.getZipCode());
		return address;
	}
}
