package com.rebuy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Mobile {

	@Id
	private int Id;
	private User user;
	private String mobileNumber;
}
