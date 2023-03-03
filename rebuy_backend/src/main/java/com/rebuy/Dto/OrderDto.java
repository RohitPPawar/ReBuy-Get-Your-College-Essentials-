package com.rebuy.Dto;

import java.time.LocalDate;


import lombok.Data;

@Data
public class OrderDto {

	private int Id;
	private GlobalCartDto globalCart; // composite key mapping
	private LocalDate orderDate;
//	private double orderAmount;

}
