package com.bootapps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapps.entitities.Product;
import com.bootapps.repos.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prepo;
	// data jpa will create an implementation for Product Repository and inject
	
	public List<Product> getProducts() {
		return prepo.findAll();
	}
}
