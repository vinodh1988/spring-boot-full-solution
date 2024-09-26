package com.bootapps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapps.entitities.Author;
import com.bootapps.entitities.Book;
import com.bootapps.repos.AuthorRepository;
import com.bootapps.utilities.RecordAlreadyExistsException;

@Service
public class AuthorService {
  @Autowired
  private AuthorRepository arepo;
  
  public List<Author> getAuthors(){
	  return arepo.findAll();
  }
  
  public void addAuthor(Author a) throws RecordAlreadyExistsException{
	   Author author= arepo.findByAuthorno(a.getAuthorno());
	   if(author!=null)
		   throw new RecordAlreadyExistsException();
	   
	   for(Book b:a.getBooks()) {
		   b.setAuthor(a);
	   }
	   arepo.save(a);
	   
  }
  
}
