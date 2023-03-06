package com.rebuy.Dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data

public class FieldDto {

	private int Id;
	@NotEmpty(message = "Field name is required")
	private String fieldName;
}
