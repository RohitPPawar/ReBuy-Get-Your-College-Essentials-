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

import com.rebuy.Dto.UserDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/")
	public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
		UserDto created = this.userServices.create(userDto);
		return new ResponseEntity<UserDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<UserDto> update(@RequestBody UserDto userDto, @PathVariable Integer Id) {
		UserDto updated = this.userServices.update(userDto, Id);
		return new ResponseEntity<UserDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.userServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAll() {
		return ResponseEntity.ok(this.userServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<UserDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.userServices.getById(Id));
	}
}
