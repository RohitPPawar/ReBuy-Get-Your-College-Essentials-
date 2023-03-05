package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.PaymentGatewayDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.Order;
import com.rebuy.model.PaymentGateway;
import com.rebuy.repositories.PaymentGatwayRepo;
import com.rebuy.service.Services;

@Service
public class PaymentGatewayServices extends Services<PaymentGatewayDto, Integer> {

	@Autowired
	private PaymentGatwayRepo gatwayRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public PaymentGatewayDto create(PaymentGatewayDto gatewayDto) {
		PaymentGateway saved = this.gatwayRepo.save(this.mapper.map(gatewayDto, PaymentGateway.class));
		return this.mapper.map(saved, PaymentGatewayDto.class);
	}

	@Override
	public PaymentGatewayDto update(PaymentGatewayDto gatewayDto, Integer id) {
		PaymentGateway old = this.gatwayRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("PaymentGateway", id));
		old.setAmount(gatewayDto.getAmount());
		old.setDate(gatewayDto.getDate());
		old.setOrder(this.mapper.map(gatewayDto.getOrder(), Order.class));
		old.setPaymentMode(gatewayDto.getPaymentMode());
		old.setPaymentStatus(gatewayDto.isPaymentStatus());
		return this.mapper.map(old, PaymentGatewayDto.class);
	}

	@Override
	public PaymentGatewayDto getById(Integer id) {
		PaymentGateway gateway = this.gatwayRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("PaymentGateway", id));
		return this.mapper.map(gateway, PaymentGatewayDto.class);
	}

	@Override
	public List<PaymentGatewayDto> getAll() {
		List<PaymentGateway> gateways = this.gatwayRepo.findAll();
		List<PaymentGatewayDto> gatewayDtos = gateways.stream()
				.map(gatway -> this.mapper.map(gatway, PaymentGatewayDto.class)).collect(Collectors.toList());
		return gatewayDtos;
	}

	@Override
	public void delete(Integer id) {
		PaymentGateway gateway = this.gatwayRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("PaymentGateway", id));
		this.gatwayRepo.delete(gateway);
	}

}
