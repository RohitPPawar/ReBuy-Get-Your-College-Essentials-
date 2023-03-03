package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.UserProductCompositeKey;

public interface UserProductKeyRepo extends JpaRepository<UserProductCompositeKey, Integer> {

}
