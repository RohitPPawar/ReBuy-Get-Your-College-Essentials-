package com.rebuy.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@OneToOne
	@JoinColumn(name = "payment_id")
	private PaymentGateway gateway;

	private LocalDate date;
}
