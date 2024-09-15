package com.altaf.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="CUSTOMER")
@Getter
@Setter
@ToString
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="spending_limit")
	private Double spendingLimit; 
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Address> address;

}
