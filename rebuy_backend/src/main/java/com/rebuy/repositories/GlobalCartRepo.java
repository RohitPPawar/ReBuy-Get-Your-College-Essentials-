package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.GlobalCart;

public interface GlobalCartRepo extends JpaRepository<GlobalCart, Integer> {

}
