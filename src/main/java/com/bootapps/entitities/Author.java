package com.bootapps.entitities;

import java.util.Set;

import org.hibernate.annotations.OnDelete;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
@Id
private Integer authorno;
@Column
private String name;

@OneToMany(mappedBy = "author",cascade  = CascadeType.ALL)
private Set<Book> books;
 
Author() {}
Author(Integer authorno,String name){
	this.authorno=authorno;
	this.name=name;
}
public Integer getAuthorno() {
	return authorno;
}
public void setAuthorno(Integer authorno) {
	this.authorno = authorno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Book> getBooks() {
	return books;
}
public void setBooks(Set<Book> books) {
	this.books = books;
}




}
