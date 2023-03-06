package com.rebuy.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payment_gateway")
public class PaymentGateway {

	@Id
	private int Id;

	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	private String paymentMode;
	private LocalDate date;
	private boolean paymentStatus;
	private double amount;

	@OneToOne(mappedBy = "gateway")
	private Invoice invoice;

}
