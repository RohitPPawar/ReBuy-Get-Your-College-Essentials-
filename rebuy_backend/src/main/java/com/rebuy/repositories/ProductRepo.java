package com.rebuy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.Category;
import com.rebuy.model.Field;
import com.rebuy.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(Category category);

	List<Product> findByField(Field field);

	List<Product> findByproductNameContaining(String productName);
}
