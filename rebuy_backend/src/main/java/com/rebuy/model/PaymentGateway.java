package com.rebuy.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PaymentGateway {

	@Id
	private int Id;
	private Order order;
	private String paymentMode;
	private LocalDate date;
	private boolean paymentStatus;
	private double amount;

}
