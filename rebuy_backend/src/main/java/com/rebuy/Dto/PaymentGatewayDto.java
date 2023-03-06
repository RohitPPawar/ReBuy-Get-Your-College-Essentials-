package com.rebuy.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PaymentGatewayDto {
	private int Id;
	private OrderDto order;
	private String paymentMode;
	private LocalDate date;
	private boolean paymentStatus;
	private double amount;

}
