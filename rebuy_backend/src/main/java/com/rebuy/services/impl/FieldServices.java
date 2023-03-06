package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.FieldDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.Field;
import com.rebuy.repositories.FieldRepo;
import com.rebuy.service.Services;

@Service
public class FieldServices extends Services<FieldDto, Integer> {

	@Autowired
	private FieldRepo fieldRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public FieldDto create(FieldDto fieldDto) {
		Field saved = this.fieldRepo.save(this.mapper.map(fieldDto, Field.class));
		return this.mapper.map(saved, FieldDto.class);
	}

	@Override
	public FieldDto update(FieldDto fieldDto, Integer id) {
		Field old = this.fieldRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Field", id));
		old.setFieldName(fieldDto.getFieldName());
		return this.mapper.map(old, FieldDto.class);
	}

	@Override
	public FieldDto getById(Integer id) {
		Field field = this.fieldRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Field", id));
		return this.mapper.map(field, FieldDto.class);
	}

	@Override
	public List<FieldDto> getAll() {
		List<Field> allFields = this.fieldRepo.findAll();
		List<FieldDto> fieldDtos = allFields.stream().map(field -> this.mapper.map(field, FieldDto.class))
				.collect(Collectors.toList());
		return fieldDtos;
	}

	@Override
	public void delete(Integer id) {
		Field field = this.fieldRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Field", id));
		this.fieldRepo.delete(field);
	}

}
