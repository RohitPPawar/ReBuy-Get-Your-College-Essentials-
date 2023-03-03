package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
