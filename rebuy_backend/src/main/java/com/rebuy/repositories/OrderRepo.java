package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
