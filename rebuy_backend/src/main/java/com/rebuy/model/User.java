package com.rebuy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	private int Id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String collegeName;
	
	
}
