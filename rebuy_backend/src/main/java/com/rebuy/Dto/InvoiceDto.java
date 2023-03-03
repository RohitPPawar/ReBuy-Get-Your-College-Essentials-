package com.rebuy.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InvoiceDto {

	private int Id;
	private PaymentGatewayDto gateway;
	private LocalDate date;
}
