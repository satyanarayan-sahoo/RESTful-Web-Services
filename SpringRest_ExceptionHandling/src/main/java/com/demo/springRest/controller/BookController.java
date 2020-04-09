package com.demo.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springRest.exception.AuthorNotFoundException;
import com.demo.springRest.exception.BookNotFoundException;
import com.demo.springRest.model.Book;
import com.demo.springRest.repository.BookRepository;

@RestController
@RequestMapping(value = "book",produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping(value = "/getBooks")
	public List<Book> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(value = "/getBookById/{id}")
    public Book findBook(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }
	
	@GetMapping(value = "/getBookByAuthor/{author}")
	public List<Book> findBook(@PathVariable String author) {
		List<Book> books = repository.findByAuthor(author);
		if(books.isEmpty()) {
			throw new AuthorNotFoundException(author);
		}
		return books;
	}
	
}//class
