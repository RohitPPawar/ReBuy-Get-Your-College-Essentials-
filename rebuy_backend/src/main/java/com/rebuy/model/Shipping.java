package com.rebuy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Shipping {

	@Id
	private int Id;
	private boolean status;
	private Order order;
}
