package com.cg.appointment.exceptions;

/**
 * 
 * @author B.Rishita
 *
 */
public class AppointmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message String is returned
	 */

	public AppointmentNotFoundException(String message) {
		super(message);
	}

}
