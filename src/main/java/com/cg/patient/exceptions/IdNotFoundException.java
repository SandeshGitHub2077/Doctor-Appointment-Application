package com.cg.patient.exceptions;

public class IdNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -401984706707645600L;

	public IdNotFoundException(String message) {
		super(message);
	}
}
