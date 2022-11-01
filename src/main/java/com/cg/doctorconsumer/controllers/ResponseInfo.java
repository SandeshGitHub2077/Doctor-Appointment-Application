package com.cg.doctorconsumer.controllers;

public class ResponseInfo {
	private int httpCode;
	private String httpStatus;
	private String message;
	private String path;
	public ResponseInfo() {
		
	}
	public ResponseInfo(int httpCode, String httpStatus, String message, String path) {
		super();
		this.httpCode = httpCode;
		this.httpStatus = httpStatus;
		this.message = message;
		this.path = path;
	}
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "ResponseInfo [httpCode=" + httpCode + ", httpStatus=" + httpStatus + ", message=" + message + ", path="
				+ path + "]";
	}
	
}
