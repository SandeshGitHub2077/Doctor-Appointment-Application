package com.cg.user.exceptions;
/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
public class UserAlreadyExistsException extends RuntimeException {
	/**
	 * Serial Version UID code for UserAlreadyExistsException
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
