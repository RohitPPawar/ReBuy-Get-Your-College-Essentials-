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

import com.rebuy.Dto.CategoryDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.CategoryServices;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServices categoryServices;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto created = this.categoryServices.create(categoryDto);
		return new ResponseEntity<CategoryDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto, @PathVariable Integer Id) {
		CategoryDto updated = this.categoryServices.update(categoryDto, Id);
		return new ResponseEntity<CategoryDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.categoryServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAll() {
		return ResponseEntity.ok(this.categoryServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<CategoryDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.categoryServices.getById(Id));
	}
}
