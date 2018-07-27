package com.raphael.cursomc.services.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public  ObjectNotFoundExceptions(String msg) {
		super(msg);		
	}
	
	public  ObjectNotFoundExceptions(String msg, Throwable cause) {
		super(msg, cause);		
	}
	
}
