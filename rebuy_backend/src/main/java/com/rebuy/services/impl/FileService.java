package com.rebuy.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rebuy.exception.ResourseNotFoundException;
import com.rebuy.model.Product;
import com.rebuy.repositories.ProductRepo;

@Service
public class FileService {
	@Autowired
	ProductRepo productRepo;

	public String uploadImage(String path, MultipartFile file, Integer productId) throws IOException {

		// file name
		String name = file.getOriginalFilename();

		// full path
		String filePath = path + File.separator + name;

		String randomId = UUID.randomUUID().toString();
		

		// create folder if not created
		File f = new File(path);

		if (!f.exists()) {
			f.mkdir();
		}
		
		
		
		String fileName1 ="../Images/"+name;
		// file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourseNotFoundException("product", productId));

		product.setImage(fileName1);
		productRepo.save(product);
		return fileName1;
	}

}
