package com.cg.user.controllers;

/**
 * 
 * @author Kambala Nitheesh kumar
 *
 */
public class ResponseInfo {
	/**
	 * HTTP status code of the response info object
	 */
	private int httpCode;
	/**
	 * HTTP status name of the response info object
	 */
	private String httpStatus;
	/**
	 * Message of the response info object
	 */
	private String message;
	/**
	 * End point of the request
	 */
	private String path;

	/**
	 * Default constructor for initializing default values.
	 */
	public ResponseInfo() {
		super();
	}

	/**
	 * 
	 * @param httpCode   HTTP status code of the response info object
	 * @param httpStatus HTTP status name of the response info object
	 * @param message    Message of the response info object
	 * @param path       End point of the request
	 */
	public ResponseInfo(int httpCode, String httpStatus, String message, String path) {
		super();
		this.httpCode = httpCode;
		this.httpStatus = httpStatus;
		this.message = message;
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
	 * Getter method for message
	 * 
	 * @return Message of the response info object
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter method for message
	 * 
	 * @param message Message of the response info object
	 */
	public void setMessage(String message) {
		this.message = message;
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
		return "ResponseInfo [httpCode=" + httpCode + ", httpStatus=" + httpStatus + ", message=" + message + ", path="
				+ path + "]";
	}

}
