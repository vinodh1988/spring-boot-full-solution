package com.bootapps.entitities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {

	@Id
	private Integer bookno;
	@Column
	private String bookname;
	@Column
	private String category;
	@Column
	private String price;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer bookno, String bookname, String category, String price) {
		super();
		this.bookno = bookno;
		this.bookname = bookname;
		this.category = category;
		this.price = price;
	}
	public Integer getBookno() {
		return bookno;
	}
	public void setBookno(Integer bookno) {
		this.bookno = bookno;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
