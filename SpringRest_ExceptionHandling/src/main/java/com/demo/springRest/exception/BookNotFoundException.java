package com.demo.springRest.exception;

public class BookNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(Long id) {
        super("Book id "+id+" is not found");
    }
	
}//class
