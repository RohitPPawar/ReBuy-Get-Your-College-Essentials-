package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.Shipping;

public interface ShippingRepo extends JpaRepository<Shipping, Integer> {

}
