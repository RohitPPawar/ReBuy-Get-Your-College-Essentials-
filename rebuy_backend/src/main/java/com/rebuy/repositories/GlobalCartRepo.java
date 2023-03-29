package com.rebuy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rebuy.model.GlobalCart;
import com.rebuy.model.User;
import com.rebuy.model.UserProductCompositeKey;

public interface GlobalCartRepo extends JpaRepository<GlobalCart, UserProductCompositeKey> {

	@Query(value = "select * from global_cart e where e.user_id = ?1",nativeQuery = true)
	List<GlobalCart> findByuserId(Integer userId);

}
