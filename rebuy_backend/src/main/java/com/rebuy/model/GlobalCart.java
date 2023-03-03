package com.rebuy.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class GlobalCart {

	@EmbeddedId
	private UserProductCompositeKey cartId;
//	private int quantity;

}
