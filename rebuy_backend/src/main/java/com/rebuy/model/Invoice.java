package com.rebuy.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Invoice {

	@Id
	private int Id;
	private PaymentGateway gateway;
	private LocalDate date;
}
