package com.bootapps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootapps.entitities.Product;
import com.bootapps.services.ProductService;
import com.bootapps.utilities.RecordAlreadyExistsException;
import com.bootapps.utilities.RecordNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	/*@GetMapping("")
	public List<Product> getProducts(){
		return pservice.getProducts();
	}*/
	
	@Operation(
			   summary="Get Product by product no",
			   description="Get Product by passing product number "
			)
			@ApiResponses(
				 value = {
						 @ApiResponse(responseCode="200", description="Users are found"),
						 @ApiResponse(responseCode="400", description="if No user exists with the id"),
						 @ApiResponse(responseCode="500", description="Server related error")
				 }	
				)
	
	@GetMapping("/{productno}")
	public ResponseEntity<Object> getProduct(@PathVariable Integer productno)
	{
		try {
			return new ResponseEntity<>(pservice.getProduct(productno),HttpStatus.OK);
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity<>("No record Exists with product no",HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}
   
	@GetMapping("")
	public ResponseEntity<List<Product>> getProduct(@RequestParam(required = false) Integer min,@RequestParam(required = false) Integer max) {
		   try {
			   if(min==null && max==null)
				   return new ResponseEntity<>(pservice.getProducts(),HttpStatus.OK);
			   else if(min==null)
				   min=0;
			   else if(max==null)
				   max=Integer.MAX_VALUE;
			  return new ResponseEntity<>(pservice.getProducts(min, max),HttpStatus.OK);	
		   }
		  
		   catch(Exception e) {
			   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		   }
		}
	@DeleteMapping("/{productno}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer productno)
	{
		try {
			pservice.deleteProduct(productno);
			return new ResponseEntity<>("Record Deleted",HttpStatus.OK);
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity<>("No record Exists with product no",HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/{productno}",method = {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> updateProduct(@PathVariable Integer productno,@RequestBody Product p)
	{
		try {
			pservice.updateProduct(productno,p);
			return new ResponseEntity<>("Record update",HttpStatus.OK);
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity<>("No record Exists with product no",HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
