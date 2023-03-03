package com.rebuy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	private int Id;
	private Category category;
	private Field field;
	private User uploadedBy;
	private String description;
	private double actualPrice;
	private double sellingPrice;
	private String image;

}
