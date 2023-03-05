package com.rebuy.model;

import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "global_cart")
public class GlobalCart {

	@EmbeddedId
	private UserProductCompositeKey cartId;

	private LocalDate date;

	@OneToOne(mappedBy = "globalCart")
	private Order order;

}
