package com.rebuy.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rebuy.payloads.ApiResponse;
import com.rebuy.payloads.FileResponce;
import com.rebuy.services.impl.FileService;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService ;
	
	@Value("${product.images}")
	private String path; 
	
	@PostMapping("/upload/{productId}")
	public ResponseEntity<FileResponce> fileupload(
			@RequestParam("image") MultipartFile image ,
			@PathVariable  Integer productId
			){
		String fileName = null;
		try {
			fileName = fileService.uploadImage(path, image,productId);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<FileResponce> (new FileResponce(null, "image not uploaded server error"),HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
		return new ResponseEntity<FileResponce> (new FileResponce(fileName, "image uploaded"),HttpStatus.OK) ;
	}
}
