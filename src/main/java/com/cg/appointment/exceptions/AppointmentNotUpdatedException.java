package com.cg.appointment.exceptions;

/**
 * 
 * @author B.Rishita
 *
 */

public class AppointmentNotUpdatedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message String is returned
	 */
	public AppointmentNotUpdatedException(String message) {
		super(message);
	}

}
