package com.rebuy.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuy.Dto.CategoryDto;
import com.rebuy.Dto.FieldDto;
import com.rebuy.Dto.ProductDto;
import com.rebuy.Dto.UserDto;
import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.Category;
import com.rebuy.model.Field;
import com.rebuy.model.Product;
import com.rebuy.model.User;
import com.rebuy.repositories.CategoryRepo;
import com.rebuy.repositories.FieldRepo;
//import com.rebuy.model.User;
import com.rebuy.repositories.ProductRepo;
import com.rebuy.repositories.UserRepo;
import com.rebuy.service.Services;

@Service
public class ProductServices extends Services<ProductDto, Integer> {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private FieldRepo fieldRepo;

	public ProductDto addProduct(ProductDto productDto, Integer uid, Integer cid, Integer fid) {

		User user = this.userRepo.findById(uid).orElseThrow(() -> new ResourseNotFoundException("user", uid));
		Category category = this.categoryRepo.findById(cid)
				.orElseThrow(() -> new ResourseNotFoundException("Category", cid));
		Field field = this.fieldRepo.findById(fid).orElseThrow(() -> new ResourseNotFoundException("Field", cid));
		productDto.setUploadedBy(this.mapper.map(user, UserDto.class));
		productDto.setCategory(this.mapper.map(category, CategoryDto.class));
		productDto.setField(this.mapper.map(field, FieldDto.class));
		Product saved = this.productRepo.save(this.mapper.map(productDto, Product.class));

		return this.mapper.map(saved, ProductDto.class);
	}

	@Override
	public ProductDto create(ProductDto productDto) {
		Product saved = this.productRepo.save(this.mapper.map(productDto, Product.class));
		return this.mapper.map(saved, ProductDto.class);
	}

	@Override
	public ProductDto update(ProductDto productDto, Integer id) {
		Product old = this.productRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("product", id));
		old.setCategory(this.mapper.map(productDto.getCategory(), Category.class));
		old.setField(this.mapper.map(productDto.getField(), Field.class));
		old.setDescription(productDto.getDescription());
		old.setActualPrice(productDto.getActualPrice());
		old.setSellingPrice(productDto.getSellingPrice());
		old.setImage(productDto.getImage());
		old.setProductName(productDto.getProductName());
//		old.setUploadedBy(this.mapper.map(productDto.getUploadedBy(), User.class));     // 
		return this.mapper.map(old, ProductDto.class);
	}

	@Override
	public ProductDto getById(Integer id) {
		Product product = this.productRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("product", id));
		return this.mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAll() {
		List<Product> products = this.productRepo.findAll();
		List<ProductDto> productDtos = products.stream().map(product -> this.mapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public void delete(Integer id) {
		Product product = this.productRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("product", id));
		this.productRepo.delete(product);
	}

	public List<ProductDto> getByCategory(Integer cid) {
		Category category = this.categoryRepo.findById(cid)
				.orElseThrow(() -> new ResourseNotFoundException("Category", cid));
		List<Product> products = this.productRepo.findByCategory(category);
		List<ProductDto> productDtos = products.stream().map(product -> this.mapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
		return productDtos;
	}

	public List<ProductDto> getByFiled(Integer fid) {
		Field field = this.fieldRepo.findById(fid).orElseThrow(() -> new ResourseNotFoundException("Field", fid));
		List<Product> products = this.productRepo.findByField(field);
		List<ProductDto> productDtos = products.stream().map(product -> this.mapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
		return productDtos;
	}

}
