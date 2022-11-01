package com.cg.patientconsumer.exceptions;

/**
 * 
 * @author Sandesh Mahajan IdNotFoundException class represents the exception
 *         that is thrown by a method when a provided ID fails to return the
 *         specified test element.
 *
 */
public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7277068657179359259L;

	/**
	 * 
	 * @param message Contains the message regarding Id error info
	 */
	public IdNotFoundException(String message) {
		super(message);
	}
}