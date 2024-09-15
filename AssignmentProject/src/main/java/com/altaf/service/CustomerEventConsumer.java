package com.altaf.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.altaf.dto.CustomerDTO;

@Service

public class CustomerEventConsumer {

//    @KafkaListener(topics = "${customer.create.topic}", groupId = "customer_group")
//    public void consumeCustomerCreateEvent(CustomerDTO customerDTO) {
//        System.out.println("Received CustomerDTO: " + customerDTO);
//        // Process the customerDTO object as needed
//    }
}
