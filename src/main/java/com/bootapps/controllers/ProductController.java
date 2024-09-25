package com.bootapps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapps.entitities.Product;
import com.bootapps.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/")
	public List<Product> getProducts(){
		return pservice.getProducts();
	}

}
