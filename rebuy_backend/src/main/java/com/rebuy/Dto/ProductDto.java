package com.rebuy.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class ProductDto {

	private int Id;
	@NotEmpty(message = "productName is required")
	private String productName;
	private CategoryDto category;
	private FieldDto field;
	private UserDto uploadedBy;

	@NotEmpty(message = "description is required")
	@Length(max = 1000)
	private String description;

	private double actualPrice;
	@NotNull(message = "selling price is required")
	private double sellingPrice;
	@NotEmpty(message = "image is required")
	private String image;

}
