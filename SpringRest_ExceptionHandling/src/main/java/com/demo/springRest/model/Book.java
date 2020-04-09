package com.demo.springRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_REST_EXCEPTION")
public class Book {
	@Id
	@Column(name = "BOOK_ID")
	private Long id;
	
	@Column(name = "BOOK_NAME")
	private String name;
	
	@Column(name = "BOOK_AUTHOR_NAME")
	private String author;
	
	@Column(name = "BOOK_PRICE")
	private Double price;

	public Book() {
		
	}

	public Book(Long id, String name, String author, Double price) {
		this.id=id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
}//class
