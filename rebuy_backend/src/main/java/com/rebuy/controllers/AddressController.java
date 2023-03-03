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

import com.rebuy.Dto.AddressDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.AddressServices;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressServices addressServices;

	@PostMapping("/")
	public ResponseEntity<AddressDto> create(@RequestBody AddressDto addressDto) {
		AddressDto created = this.addressServices.create(addressDto);
		return new ResponseEntity<AddressDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{addId}")
	public ResponseEntity<AddressDto> update(@RequestBody AddressDto addressDto, @PathVariable Integer addId) {
		AddressDto updated = this.addressServices.update(addressDto, addId);
		return new ResponseEntity<AddressDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{addId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer addId) {
		this.addressServices.delete(addId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Address deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<AddressDto>> getAll() {
		return ResponseEntity.ok(this.addressServices.getAll());
	}

	@GetMapping("/{addId}")
	public ResponseEntity<AddressDto> getById(@PathVariable Integer addId) {
		return ResponseEntity.ok(this.addressServices.getById(addId));
	}
}
