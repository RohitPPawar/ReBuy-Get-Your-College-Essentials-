package com.rebuy.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressDto {

	private int Id;
	private UserDto user;

	private String city;

	@NotEmpty(message = "state is required")
	private String state;
	private String area;

	@NotEmpty(message = "pincode required")
	@Pattern(regexp = "^[0-9]{6,6}+$", message = "pin code must contain 6 numbers")
	private String pinCode;

}
