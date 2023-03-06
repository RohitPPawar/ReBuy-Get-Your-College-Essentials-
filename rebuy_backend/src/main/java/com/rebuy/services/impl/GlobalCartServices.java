package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.GlobalCartDto;
import com.rebuy.Dto.UserProductCompositeKeyDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.GlobalCart;
import com.rebuy.model.UserProductCompositeKey;
import com.rebuy.repositories.GlobalCartRepo;
import com.rebuy.service.Services;

@Service
public class GlobalCartServices extends Services<GlobalCartDto, UserProductCompositeKeyDto> {

	@Autowired
	private GlobalCartRepo CartRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public GlobalCartDto create(GlobalCartDto cartDto) {
		GlobalCart cart = this.CartRepo.save(this.mapper.map(cartDto, GlobalCart.class));
		return this.mapper.map(cart, GlobalCartDto.class);
	}

	@Override
	public GlobalCartDto update(GlobalCartDto cartDto, UserProductCompositeKeyDto id) {
		GlobalCart old = this.CartRepo.findById(this.mapper.map(id, UserProductCompositeKey.class))
				.orElseThrow(() -> new ResourseNotFoundException("Cart", 0));
		old.setDate(cartDto.getDate());
		return this.mapper.map(old, GlobalCartDto.class);
	}

	@Override
	public GlobalCartDto getById(UserProductCompositeKeyDto id) {
		GlobalCart cart = this.CartRepo.findById(this.mapper.map(id, UserProductCompositeKey.class))
				.orElseThrow(() -> new ResourseNotFoundException("Cart", 0));
		return this.mapper.map(cart, GlobalCartDto.class);
	}

	@Override
	public List<GlobalCartDto> getAll() {
		List<GlobalCart> carts = this.CartRepo.findAll();
		List<GlobalCartDto> cartDtos = carts.stream().map(cart -> this.mapper.map(cart, GlobalCartDto.class))
				.collect(Collectors.toList());
		return cartDtos;
	}

	@Override
	public void delete(UserProductCompositeKeyDto id) {
		GlobalCart cart = this.CartRepo.findById(this.mapper.map(id, UserProductCompositeKey.class))
				.orElseThrow(() -> new ResourseNotFoundException("Cart", 0));
		this.CartRepo.delete(cart);
	}

}
