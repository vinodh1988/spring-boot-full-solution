package com.bootapps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapps.entitities.Product;
import com.bootapps.repos.ProductRepository;
import com.bootapps.utilities.RecordAlreadyExistsException;
import com.bootapps.utilities.RecordNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prepo;
	// data jpa will create an implementation for Product Repository and inject
	
	public List<Product> getProducts() {
		return prepo.findAll();
	}
	
	public Product getProduct(Integer productno)  throws RecordNotFoundException{
		Product p=prepo.findByProductno(productno);
		if(p==null)
			throw new RecordNotFoundException();
		return p;
	}
	
	public void  addProduct(Product product) throws RecordAlreadyExistsException {
		Product p=prepo.findByProductno(product.getProductno());
		if (p!=null)
			throw new RecordAlreadyExistsException();
		else
		{
			prepo.save(product); //insert or update (we defined it only for insertion)
		}
	}
	
	public void deleteProduct(Integer productno)  throws RecordNotFoundException{
		Product p=prepo.findByProductno(productno);
		if(p==null)
			throw new RecordNotFoundException();
		prepo.delete(p);
	}
	
	public void updateProduct(Integer productno,Product product)  throws RecordNotFoundException{
		Product p=prepo.findByProductno(productno);
		if(p==null)
			throw new RecordNotFoundException();
		
		product.setProductno(productno);
		product.setName(product.getName()==null?p.getName():product.getName());
		product.setCategory(product.getCategory()==null?p.getCategory():product.getCategory());
		product.setPrice(product.getPrice()==null?p.getPrice():product.getPrice());
		
		prepo.save(product);
	}
}
