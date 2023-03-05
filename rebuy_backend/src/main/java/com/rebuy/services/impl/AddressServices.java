package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.AddressDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.Address;
import com.rebuy.model.User;
import com.rebuy.repositories.AddressRepository;
import com.rebuy.service.Services;

@Service
public class AddressServices extends Services<AddressDto, Integer> {

	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public AddressDto create(AddressDto addressDto) {
		Address saved = this.addressRepo.save(this.mapper.map(addressDto, Address.class));
		return this.mapper.map(saved, AddressDto.class);
	}

	@Override
	public AddressDto update(AddressDto addressDto, Integer Id) {
		Address old = this.addressRepo.findById(Id).orElseThrow(() -> new ResourseNotFoundException("Address", Id));
		old.setUser(this.mapper.map(addressDto.getUser(), User.class));
		old.setArea(addressDto.getArea());
		old.setCity(addressDto.getCity());
		old.setPinCode(addressDto.getPinCode());
		old.setState(addressDto.getState());
		return null;
	}

	@Override
	public AddressDto getById(Integer id) {
		Address old = this.addressRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Address", id));
		return this.mapper.map(old, AddressDto.class);
	}

	@Override
	public List<AddressDto> getAll() {
		List<Address> allAddresses = this.addressRepo.findAll();
		List<AddressDto> allAddressDto = allAddresses.stream().map(add -> this.mapper.map(add, AddressDto.class))
				.collect(Collectors.toList());
		return allAddressDto;
	}

	@Override
	public void delete(Integer id) {
		Address old = this.addressRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Address", id));
		this.addressRepo.delete(old);
	}

}
