package com.cg.doctor.exceptions;

public class SpecialityNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpecialityNotFoundException(String message) {
		super(message);
	}

}
