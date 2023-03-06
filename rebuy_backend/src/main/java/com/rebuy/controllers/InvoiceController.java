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

import com.rebuy.Dto.InvoiceDto;
import com.rebuy.payloads.ApiResponse;
import com.rebuy.services.impl.InvoiceServices;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceServices invoiceServices;

	@PostMapping("/")
	public ResponseEntity<InvoiceDto> create(@RequestBody InvoiceDto invoiceDto) {
		InvoiceDto created = this.invoiceServices.create(invoiceDto);
		return new ResponseEntity<InvoiceDto>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<InvoiceDto> update(@RequestBody InvoiceDto invoiceDto, @PathVariable Integer Id) {
		InvoiceDto updated = this.invoiceServices.update(invoiceDto, Id);
		return new ResponseEntity<InvoiceDto>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer Id) {
		this.invoiceServices.delete(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Cart deleted", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<InvoiceDto>> getAll() {
		return ResponseEntity.ok(this.invoiceServices.getAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<InvoiceDto> getById(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.invoiceServices.getById(Id));
	}
}
