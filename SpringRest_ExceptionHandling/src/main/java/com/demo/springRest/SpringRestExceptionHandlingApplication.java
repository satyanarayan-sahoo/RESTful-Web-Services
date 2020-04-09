package com.demo.springRest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.springRest.model.Book;
import com.demo.springRest.repository.BookRepository;

@SpringBootApplication
public class SpringRestExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestExceptionHandlingApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDatabase(BookRepository repository) {
	        return args -> {
	            repository.save(new Book(101L,"A Guide to the Bodhisattva Way of Life", "Santideva", 105.33));
	            repository.save(new Book(102L,"The Life-Changing Magic of Tidying Up", "Marie Kondo", 675.87));
	            repository.save(new Book(103L,"Refactoring: Improving the Design of Existing Code", "Martin Fowler", 500.50));
	            repository.save(new Book(104L,"Troy", "Raj Babu", 1070.50));
	        };
	}

}
