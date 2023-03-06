package com.rebuy.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDto {

	private int Id;

	@NotEmpty(message = "first name is required")
	@Pattern(regexp = "^[A-Za-z]+$", message = "only alphabets are allowed")
	@Length(min = 3, message = "name must contain atleast 3 characters")
	private String firstName;

	@NotEmpty(message = "last name is required")
	@Pattern(regexp = "^[A-Za-z]+$", message = "only alphabets are allowed")
	@Length(min = 3, message = "name must contain atleast 3 characters")
	private String lastName;

	@Email(message = "email Id is not valid")
	@NotEmpty(message = "email is required")
	private String emailId;

	@NotEmpty
	@Length(min = 5, max = 10, message = "Password must be between 5 to 10 characters")
	private String password;

	@NotEmpty(message = "College name is required")
	@Pattern(regexp = "^[A-Za-z]+$", message = "only alphabets are allowed")
	private String collegeName;

}
