package com.cg.user.exceptions;
/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
public class UserNotFoundException extends RuntimeException {
	/**
	 * Serial Version UID code for UserNotFoundException class
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
