package com.altaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.altaf.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByFirstName(String firstName);
	
	@Query("SELECT c FROM Customer c JOIN c.address a WHERE a.city =:city")
	List<Customer> findCustomersByCity(@Param("city") String city);
	
	
	@Query("SELECT c FROM Customer c JOIN c.address a "
	         + "WHERE (:name IS NULL OR c.firstName LIKE %:name%) "
	         + "AND (:city IS NULL OR a.city = :city) "
	         + "AND (:state IS NULL OR a.state = :state)")
	    List<Customer> findCustomersByCriteria(@Param("name") String name, 
	                                           @Param("city") String city, 
	                                           @Param("state") String state);
}
