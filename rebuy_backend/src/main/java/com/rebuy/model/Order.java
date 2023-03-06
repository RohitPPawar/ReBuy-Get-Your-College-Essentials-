package com.rebuy.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@OneToOne
	@JoinColumns({ @JoinColumn(name = "user_id_cfk", referencedColumnName = "user_id"),
			@JoinColumn(name = "product_id_cfk", referencedColumnName = "product_id") })
	private GlobalCart globalCart; // composite key mapping

	private LocalDate orderDate;

	@OneToOne(mappedBy = "order")
	private PaymentGateway gateway;

	@OneToOne(mappedBy = "order")
	private Shipping shipping;
}
