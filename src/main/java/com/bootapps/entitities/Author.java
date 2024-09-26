package com.bootapps.entitities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
private Integer authorno;
private String name;

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


}
