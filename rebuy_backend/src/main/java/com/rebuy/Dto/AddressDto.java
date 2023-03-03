package com.rebuy.Dto;

import lombok.Data;

@Data
public class AddressDto {

	private int Id;
	private UserDto user;
	private String city;
	private String state;
	private String area;
	private int pinCode;

}
