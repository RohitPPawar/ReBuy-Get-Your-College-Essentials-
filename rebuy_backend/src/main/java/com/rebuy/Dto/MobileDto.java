package com.rebuy.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class MobileDto {

	private int Id;
	private UserDto user;
	@Pattern(regexp = "^[0-9]{10,10}+$", message = "Mobile number must contain 10 digits")
	@NotEmpty(message = "Mobile number is required")
	private String mobileNumber;
}
