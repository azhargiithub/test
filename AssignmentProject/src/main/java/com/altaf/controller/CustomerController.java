package com.altaf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altaf.dto.CustomerDTO;
import com.altaf.entity.Customer;
import com.altaf.exception.ErrorMessage;
import com.altaf.repository.CustomerRepository;
import com.altaf.service.CustomerService;
import com.altaf.util.ConverterUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody CustomerDTO customer) {
		log.info("Create Api Started");
		return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
	}

	@GetMapping
	public List<CustomerDTO> findCustomers(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "city", required = false) String city,
			@RequestParam(name = "state", required = false) String state) {

		log.info("Fetch Customers API started");

		List<Customer> customers;
		if (name == null && city == null && state == null) {
			customers = customerService.getAllCustomers();
		} else {
			customers = customerService.findCustomersByCriteria(name, city, state);
		}

		List<CustomerDTO> customerDTOs = customers.stream().map(ConverterUtils::convertCustomerToDTO)
				.collect(Collectors.toList());

		log.info("Fetch Customers API ended successfully");
		return customerDTOs;
	}

}
