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

import com.rebuy.Dto.FieldDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.FieldServices;

@RestController
@RequestMapping("/field")
public class FieldController {

	@Autowired
	private FieldServices fieldServices;

	@PostMapping("/")
	public ResponseEntity<FieldDto> create(@Valid @RequestBody FieldDto fieldDto) {
		FieldDto created = this.fieldServices.create(fieldDto);
		return new ResponseEntity<FieldDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<FieldDto> update(@RequestBody FieldDto fieldDto, @PathVariable Integer Id) {
		FieldDto updated = this.fieldServices.update(fieldDto, Id);
		return new ResponseEntity<FieldDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.fieldServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Field deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<FieldDto>> getAll() {
		return ResponseEntity.ok(this.fieldServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<FieldDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.fieldServices.getById(Id));
	}
}
