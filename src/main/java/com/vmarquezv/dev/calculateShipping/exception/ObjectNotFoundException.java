package com.vmarquezv.dev.calculateShipping.exception;

public class ObjectNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException() {
		super("CEP - NOT_FOUND");
	}
	
}
