package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.MobileDto;
import com.rebuy.Dto.UserDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.Mobile;
import com.rebuy.model.User;
import com.rebuy.repositories.MobileRepo;
import com.rebuy.repositories.UserRepo;
import com.rebuy.service.Services;

@Service
public class MobileServices extends Services<MobileDto, Integer> {

	@Autowired
	private MobileRepo mobileRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserRepo userRepo;

	public MobileDto addMobile(MobileDto mobileDto, Integer uid) {
		User user = this.userRepo.findById(uid).orElseThrow(() -> new ResourseNotFoundException("user", uid));
		mobileDto.setUser(this.mapper.map(user, UserDto.class));
		Mobile save = this.mobileRepo.save(this.mapper.map(mobileDto, Mobile.class));
		return this.mapper.map(save, MobileDto.class);
	}

	@Override
	public MobileDto create(MobileDto mobileDto) {
		Mobile save = this.mobileRepo.save(this.mapper.map(mobileDto, Mobile.class));
		return this.mapper.map(save, MobileDto.class);
	}

	@Override
	public MobileDto update(MobileDto mobileDto, Integer id) {
		Mobile old = this.mobileRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Mobile", id));
		old.setMobileNumber(mobileDto.getMobileNumber());
		old.setUser(this.mapper.map(mobileDto.getUser(), User.class));
		return this.mapper.map(old, MobileDto.class);
	}

	@Override
	public MobileDto getById(Integer id) {
		Mobile mobile = this.mobileRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Mobile", id));
		return this.mapper.map(mobile, MobileDto.class);
	}

	@Override
	public List<MobileDto> getAll() {
		List<Mobile> mobiles = this.mobileRepo.findAll();
		List<MobileDto> mobileDtos = mobiles.stream().map(mobile -> this.mapper.map(mobile, MobileDto.class))
				.collect(Collectors.toList());
		return mobileDtos;
	}

	@Override
	public void delete(Integer id) {
		Mobile mobile = this.mobileRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Mobile", id));
		this.mobileRepo.delete(mobile);
	}

}
