package com.rebuy.Dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserProductCompositeKeyDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDto product;
	private UserDto user;

}
