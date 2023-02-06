package com.vmarquezv.dev.calculateShipping.exception;

public class BadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public BadRequestException() {
		super("CEP - INCORRECT_REQUEST");
	}
	
}
