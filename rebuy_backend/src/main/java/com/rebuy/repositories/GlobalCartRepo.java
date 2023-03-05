package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.GlobalCart;
import com.rebuy.model.UserProductCompositeKey;

public interface GlobalCartRepo extends JpaRepository<GlobalCart, UserProductCompositeKey> {

}
