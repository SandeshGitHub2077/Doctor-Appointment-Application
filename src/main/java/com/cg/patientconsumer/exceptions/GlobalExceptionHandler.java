package com.cg.patientconsumer.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.cg.patientconsumer.controllers.ErrorInfo;

/**
 * 
 * @author Issarapu Gangadhar, Snadesh Mahajan Exception class for catching
 *         exceptions
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 
	 * @param exception          The exception to handle
	 * @param httpServletRequest HttpServletRequest type object to get the
	 *                           information about the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<ErrorInfo> httpClientErrorExceptionHandler(HttpClientErrorException exception,
			HttpServletRequest httpServletRequest) {
		String errorMessage = exception.getResponseBodyAsString();
		Map<String, String> errors = new HashMap<>();
		errorMessage = errorMessage.substring(1, errorMessage.length() - 1);
		for (String string : errorMessage.split(",")) {
			String[] keyValuePair = string.split(":");
			errors.put(keyValuePair[0].replace("\"", ""), keyValuePair[1].replace("\"", ""));
		}
		ErrorInfo info = new ErrorInfo(Integer.valueOf(errors.get("httpCode")), errors.get("httpStatus"),
				errors.get("error"), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(info, exception.getStatusCode());
	}

	/**
	 * 
	 * @param exception          The exception to handle
	 * @param httpServletRequest HttpServletRequest type object to get the
	 *                           information about the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorInfo> userNotFoundExceptionHandler(IdNotFoundException exception,
			HttpServletRequest httpServletRequest) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				exception.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * @param exception The exception to handle
	 * @param request   HttpServletRequest type object to get the information about
	 *                  the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ExceptionHandler(DoctorNotAvailableException.class)
	public ResponseEntity<ErrorInfo> doctorNotAvailableExceptionHandler(DoctorNotAvailableException exception,
			HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * @param exception The exception to handle
	 * @param request   HttpServletRequest type object to get the information about
	 *                  the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(Exception exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

}
