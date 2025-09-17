package com.dey.kaas.exeption;

public class CompanyNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CompanyNotFoundException(){
		super("Company is not Found!");
	}
	
	public CompanyNotFoundException(String msg){
		super(msg);
	}

}
