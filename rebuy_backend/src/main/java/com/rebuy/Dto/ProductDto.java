package com.rebuy.Dto;

import lombok.Data;

@Data
public class ProductDto {

	private int Id;
	private CategoryDto category;
	private FieldDto field;
	private UserDto uploadedBy;
	private String description;
	private double actualPrice;
	private double sellingPrice;
	private String image;

}
