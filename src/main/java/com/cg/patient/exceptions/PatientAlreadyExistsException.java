package com.cg.patient.exceptions;

public class PatientAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public PatientAlreadyExistsException(String message) {
		super(message);
	}
}
