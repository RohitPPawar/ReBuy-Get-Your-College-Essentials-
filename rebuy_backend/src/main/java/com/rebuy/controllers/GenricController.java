package com.rebuy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.rebuy.service.Services;

public interface GenricController<T, K, S extends Services<T, K>> {

	public default ResponseEntity<T> create(@RequestBody T t) {
//		S s = new s();
		S s = null;
		T created = s.create(t);
		return new ResponseEntity<T>(created, HttpStatus.OK);
	}

}
