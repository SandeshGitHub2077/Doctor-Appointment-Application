package com.cg.admindata.exceptions;

public class AdminAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AdminAlreadyExistException(String message) {
		super(message);
	}
}