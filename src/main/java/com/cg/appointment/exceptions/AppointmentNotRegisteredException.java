package com.cg.appointment.exceptions;

/**
 * 
 * @author B.Rishita
 *
 */
public class AppointmentNotRegisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message String is returned
	 */
	public AppointmentNotRegisteredException(String message) {
		super(message);
	}

}
