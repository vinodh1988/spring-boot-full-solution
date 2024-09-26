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

import com.bootapps.entitities.Author;
import com.bootapps.services.AuthorService;
import com.bootapps.utilities.RecordAlreadyExistsException;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
@Autowired
private AuthorService aservice;
	 @GetMapping("")
	 public List<Author> getAuthors(){
		 return aservice.getAuthors();
	 }
	 
	 @PostMapping("")
	 public ResponseEntity<String> addAuthor(@RequestBody Author author){
		 
		 try {
			 aservice.addAuthor(author);
			 return new ResponseEntity<>("Author record inserted",HttpStatus.CREATED);
			 
		 }
		 catch(RecordAlreadyExistsException e) {
			 return new ResponseEntity<>("Record Already Exists with this id",HttpStatus.BAD_REQUEST);
		 }
		 catch(Exception e) {
			 return new ResponseEntity<String>("Server error",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
}
