package com.cg.appointment.exceptions;

/**
 * 
 * @author B.Rishita
 *
 */

public class DoctorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message String is returned
	 */
	public DoctorNotFoundException(String message) {
		super(message);
	}

}
