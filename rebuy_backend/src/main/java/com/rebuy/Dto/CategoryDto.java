package com.rebuy.Dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CategoryDto {

	private int Id;
	@NotEmpty(message = "Category Type is required")
	private String type;
}
