package com.bootapps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapps.entitities.Author;
import com.bootapps.repos.AuthorRepository;
import com.bootapps.services.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
@Autowired
private AuthorService aservice;
	 @GetMapping("")
	 public List<Author> getAuthors(){
		 return aservice.getAuthors();
	 }
}
