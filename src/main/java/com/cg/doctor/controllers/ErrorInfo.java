package com.cg.doctor.controllers;

public class ErrorInfo {
	private int httpCode;
	private String httpStatus;
	private String error;
	private String path;

	public ErrorInfo() {

	}

	public ErrorInfo(int httpCode, String httpStatus, String error, String path) {
		super();
		this.httpCode = httpCode;
		this.httpStatus = httpStatus;
		this.error = error;
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ErrorInfo [httpCode=" + httpCode + ", httpStatus=" + httpStatus + ", error=" + error + ", path=" + path
				+ "]";
	}

}
