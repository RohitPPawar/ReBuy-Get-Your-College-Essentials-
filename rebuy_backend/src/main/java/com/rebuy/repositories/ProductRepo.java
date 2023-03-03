package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
