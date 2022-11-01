package com.cg.appointment.exceptions;

/**
 * 
 * @author B.Rishita
 *
 */

public class AppointmentStatusNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message String is returned
	 */
	public AppointmentStatusNotFoundException(String message) {
		super(message);
	}

}
