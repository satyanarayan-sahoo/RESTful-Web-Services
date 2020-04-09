package com.demo.springRest.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springRest.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	public List<Book> findByAuthor(String author);
	
}
