package com.rebuy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rebuy.Dto.ShippingDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.ShippingServices;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

	@Autowired
	private ShippingServices shippingServices;

	@PostMapping("/")
	public ResponseEntity<ShippingDto> create(@RequestBody ShippingDto shippingDto) {
		ShippingDto created = this.shippingServices.create(shippingDto);
		return new ResponseEntity<ShippingDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<ShippingDto> update(@RequestBody ShippingDto shippingDto, @PathVariable Integer Id) {
		ShippingDto updated = this.shippingServices.update(shippingDto, Id);
		return new ResponseEntity<ShippingDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.shippingServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<ShippingDto>> getAll() {
		return ResponseEntity.ok(this.shippingServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<ShippingDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.shippingServices.getById(Id));
	}
}
