package com.cg.user.exceptions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.user.controllers.ErrorInfo;

/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * Validation exception Handler method
	 * 
	 * @param exception          MethodArgumentNotValidException Object, contains
	 *                           all the information about exception
	 * @param httpServletRequest Contains information about request
	 * @return ResponseEntity<ErrorInfo>
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
	 * Exception is thrown when user is present in the database and tried to insert
	 * same user
	 * 
	 * @param exception          contains all the information about exception
	 * @param httpServletRequest Contains information about request
	 * @return ResponseEntity<ErrorInfo>
	 */
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> userAlreadyExistsExceptionHandler(UserAlreadyExistsException exception,
			HttpServletRequest httpServletRequest) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

	/**
	 * UserNotFoundException is thrown when the user is not present in the database
	 * @param exception          contains all the information about exception
	 * @param httpServletRequest Contains information about request
	 * @return ResponseEntity<ErrorInfo>
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> userNotFoundExceptionHandler(UserNotFoundException exception,
			HttpServletRequest httpServletRequest) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				exception.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	}

	/**
	 * This Exception Handler methods will handle every Exception
	 * @param exception contains all the information about exception
	 * @param httpServletRequest Contains information about request
	 * @return ResponseEntity<ErrorInfo>
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception, HttpServletRequest httpServletRequest) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
