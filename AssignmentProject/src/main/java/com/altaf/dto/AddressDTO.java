package com.altaf.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {

	private String type;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;

}
