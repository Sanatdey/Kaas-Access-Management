package com.dey.kaas.exeption;

public class AccessOrAccessGroupNotFoundException extends RuntimeException {

	public AccessOrAccessGroupNotFoundException() {
		super();
	}
	
	
	public AccessOrAccessGroupNotFoundException(String msg) {
		super(msg);
	}

}
