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

import com.rebuy.Dto.UserProductCompositeKeyDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.UserProductCompositeKeyServices;

@RestController
@RequestMapping("/userPruductKey")
public class UserProductKeyController {

	@Autowired
	private UserProductCompositeKeyServices userProductKeyServices;

	@PostMapping("/")
	public ResponseEntity<UserProductCompositeKeyDto> create(@RequestBody UserProductCompositeKeyDto userPoductKeyDto) {
		UserProductCompositeKeyDto created = this.userProductKeyServices.create(userPoductKeyDto);
		return new ResponseEntity<UserProductCompositeKeyDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<UserProductCompositeKeyDto> update(@RequestBody UserProductCompositeKeyDto userPoductKeyDto,
			@PathVariable Integer Id) {
		UserProductCompositeKeyDto updated = this.userProductKeyServices.update(userPoductKeyDto, Id);
		return new ResponseEntity<UserProductCompositeKeyDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.userProductKeyServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserProductCompositeKeyDto>> getAll() {
		return ResponseEntity.ok(this.userProductKeyServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<UserProductCompositeKeyDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.userProductKeyServices.getById(Id));
	}
}
