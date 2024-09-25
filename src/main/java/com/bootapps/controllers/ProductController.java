package com.bootapps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapps.entitities.Product;
import com.bootapps.services.ProductService;
import com.bootapps.utilities.RecordAlreadyExistsException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@GetMapping("")
	public List<Product> getProducts(){
		return pservice.getProducts();
	}
	
	@PostMapping("")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		try {
			pservice.addProduct(product);
			return new ResponseEntity<String>("Inserted successfuly",HttpStatus.CREATED);
		}
		catch(RecordAlreadyExistsException e) 
		{
		
			return new ResponseEntity<String>("Record with id already exists",HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Server Side error",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

}
