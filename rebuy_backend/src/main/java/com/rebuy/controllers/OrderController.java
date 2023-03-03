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

import com.rebuy.Dto.OrderDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.OrderServices;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderServices orderServices;

	@PostMapping("/")
	public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
		OrderDto created = this.orderServices.create(orderDto);
		return new ResponseEntity<OrderDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<OrderDto> update(@RequestBody OrderDto orderDto, @PathVariable Integer Id) {
		OrderDto updated = this.orderServices.update(orderDto, Id);
		return new ResponseEntity<OrderDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.orderServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<OrderDto>> getAll() {
		return ResponseEntity.ok(this.orderServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<OrderDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.orderServices.getById(Id));
	}
}
