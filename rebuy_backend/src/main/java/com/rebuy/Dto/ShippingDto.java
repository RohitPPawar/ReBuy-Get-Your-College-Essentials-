package com.rebuy.Dto;

import lombok.Data;

@Data
public class ShippingDto {

	private int Id;
	private boolean status;
	private OrderDto order;
}
