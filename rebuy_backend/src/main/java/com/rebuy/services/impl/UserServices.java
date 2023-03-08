package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.LoginDetails;
import com.rebuy.Dto.UserDto;
import com.rebuy.exception.InvalidUserException;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.User;
import com.rebuy.repositories.UserRepo;
import com.rebuy.service.Services;

@Service
public class UserServices extends Services<UserDto, Integer> {

	private static final Exception InvalidUserException = null;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper mapper;
	private boolean isUnique = true;
	private com.rebuy.exception.InvalidUserException ex;

	@Override
	public UserDto create(UserDto userDto) {
		User user = this.mapper.map(userDto, User.class);
		User saved = this.userRepo.save(user);
		return this.mapper.map(saved, UserDto.class);
	}

	public UserDto createUser(UserDto userDto) throws com.rebuy.exception.InvalidUserException {
		List<User> allUser = this.userRepo.findAll();

		for (User user : allUser) {
			if (user.getEmailId().equals(userDto.getEmailId())) {
				isUnique = false;
				break;
			}
		}
		if (!isUnique) {
			throw ex = new InvalidUserException("User alredy exits");
		}

		User user = this.mapper.map(userDto, User.class);
		User saved = this.userRepo.save(user);
		return this.mapper.map(saved, UserDto.class);
	}

//	login user
	public UserDto loginUser(LoginDetails loginDetails) throws com.rebuy.exception.InvalidUserException {
		User user = this.userRepo.findByemailId(loginDetails.getEmail());
//		System.out.println(user);
//		System.out.println("\n======\n"+loginDetails);
		if (user == null) {
			throw ex = new InvalidUserException("Invalid username ");
		}
		if (!user.getPassword().equals(loginDetails.getPassword())) {
			throw ex = new InvalidUserException("Invalid password ");
		}
		UserDto userDto = this.mapper.map(user, UserDto.class);
		userDto.setPassword(null);
		return userDto;
	}

	@Override
	public UserDto update(UserDto userDto, Integer userId) {
		User old = this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User", userId));
		old.setFirstName(userDto.getFirstName());
		old.setLastName(userDto.getLastName());
		old.setEmailId(userDto.getEmailId());
		old.setCollegeName(userDto.getCollegeName());
		old.setPassword(userDto.getPassword());
		return this.mapper.map(old, UserDto.class);
	}

	@Override
	public UserDto getById(Integer userId) {
		User old = this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User", userId));
		return this.mapper.map(old, UserDto.class);
	}

	@Override
	public List<UserDto> getAll() {
		List<User> allUser = this.userRepo.findAll();
		List<UserDto> allUserDto = allUser.stream().map(user -> this.mapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return allUserDto;
	}

	@Override
	public void delete(Integer userId) {
		User old = this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User", userId));
		this.userRepo.delete(old);
	}

}
