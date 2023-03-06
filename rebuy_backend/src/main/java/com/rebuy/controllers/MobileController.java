package com.rebuy.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.rebuy.Dto.MobileDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.MobileServices;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@Autowired
	private MobileServices mobileServices;

	@PostMapping("/user/{uid}")
	public ResponseEntity<MobileDto> create(@Valid @RequestBody MobileDto MobileDto, @PathVariable Integer uid) {
		MobileDto created = this.mobileServices.addMobile(MobileDto, uid);
		return new ResponseEntity<MobileDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<MobileDto> update(@RequestBody MobileDto MobileDto, @PathVariable Integer Id) {
		MobileDto updated = this.mobileServices.update(MobileDto, Id);
		return new ResponseEntity<MobileDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.mobileServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<MobileDto>> getAll() {
		return ResponseEntity.ok(this.mobileServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<MobileDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.mobileServices.getById(Id));
	}
}
