package com.cg.doctor.exceptions;

public class DoctorAlreadyPresentException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DoctorAlreadyPresentException(String message) {
		
		super(message);
	}

}
