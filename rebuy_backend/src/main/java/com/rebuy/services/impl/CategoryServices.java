package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.CategoryDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.Category;
import com.rebuy.repositories.CategoryRepo;
import com.rebuy.service.Services;

@Service
public class CategoryServices extends Services<CategoryDto, Integer> {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto create(CategoryDto categoryDto) {
		Category saved = this.categoryRepo.save(this.mapper.map(categoryDto, Category.class));
		return this.mapper.map(saved, CategoryDto.class);
	}

	@Override
	public CategoryDto update(CategoryDto categoryDto, Integer id) {
		Category old = this.categoryRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Category", id));
		old.setType(categoryDto.getType());
		Category updated = this.categoryRepo.save(old); 
		return this.mapper.map(updated, CategoryDto.class);
	}

	@Override
	public CategoryDto getById(Integer id) {
		Category category = this.categoryRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Category", id));
		return this.mapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAll() {
		List<Category> allCategories = this.categoryRepo.findAll();
		List<CategoryDto> allCategoryDtos = allCategories.stream().map(cat -> this.mapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
		return allCategoryDtos;
	}

	@Override
	public void delete(Integer id) {
		Category category = this.categoryRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Category", id));
		this.categoryRepo.delete(category);
	}

}
