package com.rebuy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rollId;
	private String name;

	public int getRollId() {
		return rollId;
	}

	public void setRollId(int rollId) {
		this.rollId = rollId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role(int rollId, String name) {
		super();
		this.rollId = rollId;
		this.name = name;
	}

	public Role() {
		super();
	}

}
