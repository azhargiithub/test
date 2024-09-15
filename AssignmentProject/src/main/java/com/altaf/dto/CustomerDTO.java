package com.altaf.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDTO {

	private String customerId;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private Double spendingLimit; 
	
	private String mobileNumber;
	
	private List<AddressDTO> address;
	
}
