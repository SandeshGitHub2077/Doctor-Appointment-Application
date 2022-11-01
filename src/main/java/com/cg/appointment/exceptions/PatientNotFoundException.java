package com.cg.appointment.exceptions;

/**
 * 
 * @author B.Rishita
 *
 */
public class PatientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message String is returned
	 */
	public PatientNotFoundException(String message) {
		super(message);
	}

}
