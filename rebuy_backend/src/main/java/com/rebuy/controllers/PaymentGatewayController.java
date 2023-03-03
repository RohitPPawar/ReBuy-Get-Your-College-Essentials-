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

import com.rebuy.Dto.PaymentGatewayDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.PaymentGatewayServices;

@RestController
@RequestMapping("/paymentGateway")
public class PaymentGatewayController {

	@Autowired
	private PaymentGatewayServices paymentGatewayServices;

	@PostMapping("/")
	public ResponseEntity<PaymentGatewayDto> create(@RequestBody PaymentGatewayDto paymentGatewayDto) {
		PaymentGatewayDto created = this.paymentGatewayServices.create(paymentGatewayDto);
		return new ResponseEntity<PaymentGatewayDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<PaymentGatewayDto> update(@RequestBody PaymentGatewayDto paymentGatewayDto, @PathVariable Integer Id) {
		PaymentGatewayDto updated = this.paymentGatewayServices.update(paymentGatewayDto, Id);
		return new ResponseEntity<PaymentGatewayDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.paymentGatewayServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<PaymentGatewayDto>> getAll() {
		return ResponseEntity.ok(this.paymentGatewayServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<PaymentGatewayDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.paymentGatewayServices.getById(Id));
	}
}
