package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.ShippingDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.Order;
import com.rebuy.model.Shipping;
import com.rebuy.repositories.ShippingRepo;
import com.rebuy.service.Services;

@Service
public class ShippingServices extends Services<ShippingDto, Integer> {

	@Autowired
	private ShippingRepo shippingRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ShippingDto create(ShippingDto shippingDto) {
		Shipping saved = this.shippingRepo.save(this.mapper.map(shippingDto, Shipping.class));
		return this.mapper.map(saved, ShippingDto.class);
	}

	@Override
	public ShippingDto update(ShippingDto shippingDto, Integer id) {
		Shipping old = this.shippingRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Shipping", id));
		old.setOrder(this.mapper.map(shippingDto.getOrder(), Order.class));
		old.setStatus(shippingDto.isStatus());
		return this.mapper.map(old, ShippingDto.class);
	}

	@Override
	public ShippingDto getById(Integer id) {
		Shipping shipping = this.shippingRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Shipping", id));
		return this.mapper.map(shipping, ShippingDto.class);
	}

	@Override
	public List<ShippingDto> getAll() {
		List<Shipping> shippings = this.shippingRepo.findAll();
		List<ShippingDto> shippingDtos = shippings.stream()
				.map(shipping -> this.mapper.map(shipping, ShippingDto.class)).collect(Collectors.toList());
		return shippingDtos;
	}

	@Override
	public void delete(Integer id) {
		Shipping shipping = this.shippingRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Shipping", id));
		this.shippingRepo.delete(shipping);
	}

}
