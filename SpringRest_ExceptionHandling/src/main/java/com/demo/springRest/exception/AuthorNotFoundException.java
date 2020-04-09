package com.demo.springRest.exception;

public class AuthorNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AuthorNotFoundException(String author) {
        super("Author name "+author+" is not found");
    }
	
}//class
