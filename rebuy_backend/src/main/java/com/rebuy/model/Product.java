package com.rebuy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String productName;

	@ManyToOne
	@JoinColumn(name = "uploadedBy")
	private User uploadedBy;

	private String description;
	private double actualPrice;
	private double sellingPrice;
	private String image;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "field_id")
	private Field field;

}
