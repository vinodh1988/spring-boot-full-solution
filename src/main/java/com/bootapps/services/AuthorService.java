package com.bootapps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapps.entitities.Author;
import com.bootapps.repos.AuthorRepository;

@Service
public class AuthorService {
  @Autowired
  private AuthorRepository arepo;
  
  public List<Author> getAuthors(){
	  return arepo.findAll();
  }
  
}
