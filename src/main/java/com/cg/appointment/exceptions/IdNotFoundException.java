package com.cg.appointment.exceptions;

/**
 * 
 * @author B.Rishita
 *
 */
public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message String is returned
	 */
	public IdNotFoundException(String message) {
		super(message);
	}

}
