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

import com.rebuy.Dto.ProductDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.ProductServices;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServices productServices;

	@PostMapping("/")
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
		ProductDto created = this.productServices.create(productDto);
		return new ResponseEntity<ProductDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto, @PathVariable Integer Id) {
		ProductDto updated = this.productServices.update(productDto, Id);
		return new ResponseEntity<ProductDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.productServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getAll() {
		return ResponseEntity.ok(this.productServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<ProductDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.productServices.getById(Id));
	}
}
