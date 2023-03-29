package com.rebuy.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.GlobalCartDto;
import com.rebuy.Dto.UserProductCompositeKeyDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.GlobalCart;
import com.rebuy.model.Product;
import com.rebuy.model.User;
import com.rebuy.model.UserProductCompositeKey;
import com.rebuy.repositories.GlobalCartRepo;
import com.rebuy.repositories.ProductRepo;
import com.rebuy.repositories.UserRepo;
import com.rebuy.service.Services;

@Service
public class GlobalCartServices extends Services<GlobalCartDto, UserProductCompositeKeyDto> {

	@Autowired
	private GlobalCartRepo CartRepo;
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ProductRepo productRepo;

	public GlobalCartDto addToCart(Integer userId, Integer productId) {

		//extracting the user from database with given id
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User", userId));
		
		//extracting product from database with given id
		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourseNotFoundException("Product", productId));

		/*
		 * creating object of UserProductKey class (this class contains product and user which are used as 
		 * a composite primary key in a GlobalCart table )   
		 */
		UserProductCompositeKey key = new UserProductCompositeKey(product, user);
		
		//creating object of GlobalCart initialize with key which contain object of user and product
		//also we are initializing date field with current date 
		GlobalCart cart = new GlobalCart(key, LocalDate.now());

		//inserting the object of cart into database
		GlobalCart saved = this.CartRepo.save(cart);

		//converting the object which is saved into database into dto and returning it 
		return this.mapper.map(saved, GlobalCartDto.class);

	}

	public List<GlobalCartDto> getAllByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User", userId));

		List<GlobalCart> carts = this.CartRepo.findByuserId(user.getId());
		List<GlobalCartDto> cartDtos = carts.stream().map(cart -> this.mapper.map(cart, GlobalCartDto.class))
				.collect(Collectors.toList());
		return cartDtos;
	}

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
