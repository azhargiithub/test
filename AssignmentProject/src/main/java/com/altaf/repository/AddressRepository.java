package com.altaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altaf.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
