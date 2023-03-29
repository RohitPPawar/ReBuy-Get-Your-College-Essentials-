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

import com.rebuy.Dto.GlobalCartDto;
import com.rebuy.Dto.UserProductCompositeKeyDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.GlobalCartServices;

@RestController
@RequestMapping("/cart")
public class GlobalCartController {

	@Autowired
	private GlobalCartServices globalCartServices;

	@PostMapping("/")
	public ResponseEntity<GlobalCartDto> create(@RequestBody GlobalCartDto globalCartDto) {
		GlobalCartDto created = this.globalCartServices.create(globalCartDto);
		return new ResponseEntity<GlobalCartDto>(created, HttpStatus.CREATED);
	}

	//add to cart
	@PostMapping("/user/{userId}/product/{productId}")
	public ResponseEntity<GlobalCartDto> addProduct(@PathVariable Integer userId, @PathVariable Integer productId) {
		GlobalCartDto created = this.globalCartServices.addToCart(userId, productId);
		return new ResponseEntity<GlobalCartDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<GlobalCartDto> update(@RequestBody GlobalCartDto globalCartDto,
			@PathVariable UserProductCompositeKeyDto Id) {
		GlobalCartDto updated = this.globalCartServices.update(globalCartDto, Id);
		return new ResponseEntity<GlobalCartDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable UserProductCompositeKeyDto Id) {
		this.globalCartServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<GlobalCartDto>> getAll() {
		return ResponseEntity.ok(this.globalCartServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<GlobalCartDto> getById(@PathVariable UserProductCompositeKeyDto Id) {
		return ResponseEntity.ok(this.globalCartServices.getById(Id));
	}
	
	@GetMapping("/user/{userId}/products")
	public ResponseEntity<List<GlobalCartDto>> getAllProducts(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.globalCartServices.getAllByUser(userId));
	}
}
