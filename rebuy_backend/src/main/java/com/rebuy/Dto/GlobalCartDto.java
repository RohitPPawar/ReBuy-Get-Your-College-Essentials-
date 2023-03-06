package com.rebuy.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class GlobalCartDto {

	private UserProductCompositeKeyDto cartId;
//	private int quantity;
	private LocalDate date; 
	
}

