package com.rebuy.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Order {

	@Id
	private int Id;
	private GlobalCart globalCart; // composite key mapping
	private LocalDate orderDate;
//	private double orderAmount;

}
