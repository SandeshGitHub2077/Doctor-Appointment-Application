package com.cg.patientconsumer.exceptions;

/**
 * 
 * @author Issarapu Gangadhar, Sandesh Mahajan
 *
 */
public class DoctorNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = -8022877945027956626L;

	/**
	 * 
	 * @param message Contains the message regarding doctor availability
	 */
	public DoctorNotAvailableException(String message) {
		super(message);
	}
}
