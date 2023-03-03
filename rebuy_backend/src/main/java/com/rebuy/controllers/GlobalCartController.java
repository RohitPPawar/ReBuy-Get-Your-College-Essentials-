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
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.GlobalCartServices;

@RestController
@RequestMapping("/globalCart")
public class GlobalCartController {

	@Autowired
	private GlobalCartServices globalCartServices;

	@PostMapping("/")
	public ResponseEntity<GlobalCartDto> create(@RequestBody GlobalCartDto globalCartDto) {
		GlobalCartDto created = this.globalCartServices.create(globalCartDto);
		return new ResponseEntity<GlobalCartDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<GlobalCartDto> update(@RequestBody GlobalCartDto globalCartDto, @PathVariable Integer Id) {
		GlobalCartDto updated = this.globalCartServices.update(globalCartDto, Id);
		return new ResponseEntity<GlobalCartDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.globalCartServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<GlobalCartDto>> getAll() {
		return ResponseEntity.ok(this.globalCartServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<GlobalCartDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.globalCartServices.getById(Id));
	}
}
