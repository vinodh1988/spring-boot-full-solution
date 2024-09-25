package com.bootapps.entitities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
   
	@Id
	private Integer productno;
	@Column
	private String name;
	@Column
	private String category;
	@Column
	private double price;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(Integer productno, String name, String category, double price) {
		super();
		this.productno = productno;
		this.name = name;
		this.category = category;
		this.price = price;
	}


	public Integer getProductno() {
		return productno;
	}
	public void setProductno(Integer productno) {
		this.productno = productno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
