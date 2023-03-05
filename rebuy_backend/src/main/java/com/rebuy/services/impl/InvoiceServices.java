package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.InvoiceDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.Invoice;
import com.rebuy.model.PaymentGateway;
import com.rebuy.repositories.InvoiceRepo;
import com.rebuy.service.Services;

@Service
public class InvoiceServices extends Services<InvoiceDto, Integer> {

	@Autowired
	private InvoiceRepo invoiceRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public InvoiceDto create(InvoiceDto invoiceDto) {
		Invoice invoice = this.invoiceRepo.save(this.mapper.map(invoiceDto, Invoice.class));
		return this.mapper.map(invoice, InvoiceDto.class);
	}

	@Override
	public InvoiceDto update(InvoiceDto invoiceDto, Integer id) {
		Invoice old = this.invoiceRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Invoice", id));
		old.setDate(invoiceDto.getDate());
		old.setGateway(this.mapper.map(invoiceDto.getGateway(), PaymentGateway.class));
		return this.mapper.map(old, InvoiceDto.class);
	}

	@Override
	public InvoiceDto getById(Integer id) {
		Invoice invoice = this.invoiceRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Invoice", id));
		return this.mapper.map(invoice, InvoiceDto.class);
	}

	@Override
	public List<InvoiceDto> getAll() {
		List<Invoice> invoices = this.invoiceRepo.findAll();
		List<InvoiceDto> invoiceDtos = invoices.stream().map(invoice -> this.mapper.map(invoice, InvoiceDto.class))
				.collect(Collectors.toList());
		return invoiceDtos;
	}

	@Override
	public void delete(Integer id) {
		Invoice invoice = this.invoiceRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Invoice", id));
		this.invoiceRepo.delete(invoice);
	}

}
