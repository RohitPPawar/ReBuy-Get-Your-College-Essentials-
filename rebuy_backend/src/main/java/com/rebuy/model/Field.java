package com.rebuy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fields")
public class Field {

	@Id
	private int Id;
	private String fieldName;

	@OneToMany(mappedBy = "field")
	private List<Product> products;
}
