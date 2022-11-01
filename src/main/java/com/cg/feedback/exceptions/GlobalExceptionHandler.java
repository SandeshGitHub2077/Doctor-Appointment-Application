package com.cg.feedback.exceptions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.feedback.controller.ErrorInfo;

/**
 * 
 * @author Sandesh Mahajan Exception class for handling the uncaught runtime
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
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception,
			HttpServletRequest httpServletRequest) {
		StringBuilder message = new StringBuilder();
		List<ObjectError> listErrors = exception.getAllErrors();
		for (ObjectError obj : listErrors) {
			FieldError fe = (FieldError) obj;
			message.append(fe.getField() + "=" + fe.getDefaultMessage() + ";");
		}

		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				message.toString(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
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
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
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
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
