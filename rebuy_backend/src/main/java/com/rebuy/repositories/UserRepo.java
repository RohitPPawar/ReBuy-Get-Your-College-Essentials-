package com.rebuy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rebuy.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByemailId(String emailId);

}
