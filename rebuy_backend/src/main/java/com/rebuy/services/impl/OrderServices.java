package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.OrderDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.GlobalCart;
import com.rebuy.model.Order;
import com.rebuy.repositories.OrderRepo;
import com.rebuy.service.Services;

@Service
public class OrderServices extends Services<OrderDto, Integer> {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public OrderDto create(OrderDto orderDto) {
		Order saved = this.orderRepo.save(this.mapper.map(orderDto, Order.class));
		return this.mapper.map(saved, OrderDto.class);
	}

	@Override
	public OrderDto update(OrderDto orderDto, Integer id) {
		Order old = this.orderRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Order", id));
		old.setOrderDate(orderDto.getOrderDate());
		old.setGlobalCart(this.mapper.map(orderDto.getGlobalCart(), GlobalCart.class));
		return this.mapper.map(old, OrderDto.class);
	}

	@Override
	public OrderDto getById(Integer id) {
		Order order = this.orderRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Order", id));
		return this.mapper.map(order, OrderDto.class);
	}

	@Override
	public List<OrderDto> getAll() {
		List<Order> orders = this.orderRepo.findAll();
		List<OrderDto> orderDtos = orders.stream().map(order -> this.mapper.map(order, OrderDto.class))
				.collect(Collectors.toList());
		return orderDtos;
	}

	@Override
	public void delete(Integer id) {
		Order order = this.orderRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Order", id));
		this.orderRepo.delete(order);
	}

}
