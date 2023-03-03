package com.rebuy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Address {

	@Id
	private int Id;
	private User user;
	private String city;
	private String state;
	private String area;
	private int pinCode;

}
