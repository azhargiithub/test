package com.altaf.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.kafka.core.KafkaTemplate;

import com.altaf.dto.CustomerDTO;
import com.altaf.entity.Address;
import com.altaf.entity.Customer;
import com.altaf.exception.ErrorMessage;
import com.altaf.repository.CustomerRepository;
import com.altaf.util.ConverterUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Value("${customer.create.topic}")
	private String customerCreateTopic;

	private final KafkaTemplate<String, Object> kafkaTemplate;

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository, KafkaTemplate<String, Object> kafkaTemplate) {
		this.customerRepository = customerRepository;
		this.kafkaTemplate = kafkaTemplate;
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public List<Customer> findCustomersByCriteria(String name, String city, String state) {
		if (name == null && city == null && state == null) {
			log.info("Fetching All customer record");
			return getAllCustomers();
		}
		return customerRepository.findCustomersByCriteria(name, city, state);
	}

	@Transactional(value = "transactionManager", rollbackFor = Exception.class)
	public String saveCustomer(CustomerDTO customerDTO) {
		log.info("Inside Customer Service for creating customer");
		Customer customerEntity = ConverterUtils.convertDTOToCustomer(customerDTO);
		List<Address> addressEntity = Optional.ofNullable(customerDTO.getAddress())
				.orElseThrow(() -> new ErrorMessage("ERR4", "Address list cannot be null")).stream()
				.map(ConverterUtils::convertDTOToAddress).collect(Collectors.toList());
		customerEntity.setAddress(addressEntity);
		if (!ObjectUtils.isEmpty(customerEntity)) {
			for (Address address : addressEntity) {
				address.setCustomer(customerEntity);
			}

			try {
				customerRepository.save(customerEntity);
				log.info("Customer data saved Successfully for customerId :{}", customerDTO.getCustomerId());
//				kafkaTemplate.send(customerCreateTopic,customerDTO);
				return "Data Saved Successfully";

			} catch (Exception e) {
				throw new ErrorMessage("ERRO9", e.getMessage());

			}
		} else {
			throw new ErrorMessage("ERR01", "Customer is empty");
		}

	}

}
