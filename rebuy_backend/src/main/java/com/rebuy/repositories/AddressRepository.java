package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
