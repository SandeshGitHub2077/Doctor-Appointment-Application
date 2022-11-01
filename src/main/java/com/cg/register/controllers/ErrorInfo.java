package com.cg.register.controllers;

/**
 * 
 * @author Kambala Nitheesh kumar
 *
 */
public class ErrorInfo {
	/**
	 * HTTP status code of the response info object
	 */
	private int httpCode;
	/**
	 * HTTP status name of the response info object
	 */
	private String httpStatus;
	/**
	 * Error Message of the response info object
	 */
	private String error;
	/**
	 * End point of the request
	 */
	private String path;

	/**
	 * Default constructor for initializing default values.
	 */
	public ErrorInfo() {
		super();
	}

	/**
	 * 
	 * @param httpCode   HTTP status code of the response info object
	 * @param httpStatus HTTP status name of the response info object
	 * @param error      Error Message of the response info object
	 * @param path       End point of the request
	 */
	public ErrorInfo(int httpCode, String httpStatus, String error, String path) {
		super();
		this.httpCode = httpCode;
		this.httpStatus = httpStatus;
		this.error = error;
		this.path = path;
	}

	/**
	 * Getter method for httpCode
	 * 
	 * @return HTTP status code of the response info object
	 */
	public int getHttpCode() {
		return httpCode;
	}

	/**
	 * Setter method for httpCode
	 * 
	 * @param httpCode HTTP status code of the response info object
	 */
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	/**
	 * Getter method for httpStatus
	 * 
	 * @return HTTP status name of the response info object
	 */
	public String getHttpStatus() {
		return httpStatus;
	}

	/**
	 * Setter method for httpStatus
	 * 
	 * @param httpStatus HTTP status name of the response info object
	 */
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * Getter method for error
	 * 
	 * @return Error Message of the response info object
	 */
	public String getError() {
		return error;
	}

	/**
	 * Setter method for error
	 * 
	 * @param error Error Message of the response info object
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * Getter method for path
	 * 
	 * @return End point of the request
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Setter method for path
	 * 
	 * @param path End point of the request
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * toString() overridden
	 */
	@Override
	public String toString() {
		return "ErrorInfo [httpCode=" + httpCode + ", httpStatus=" + httpStatus + ", error=" + error + ", path=" + path
				+ "]";
	}

}