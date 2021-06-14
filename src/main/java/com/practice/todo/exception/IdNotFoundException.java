package com.practice.todo.exception;

public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdNotFoundException(String string) {
		super(string);
	}
	
}
