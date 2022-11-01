package com.cg.patient.exceptions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.patient.controllers.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(MethodArgumentNotValidException exception,
			HttpServletRequest request) {
		StringBuilder message = new StringBuilder();
		List<ObjectError> listErrors = exception.getAllErrors();
		for (ObjectError obj : listErrors) {
			FieldError fe = (FieldError) obj;
			message.append(fe.getField() + "=" + fe.getDefaultMessage() + ";");
		}
		ErrorInfo rinfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				message.toString(), request.getRequestURI());
		return new ResponseEntity<>(rinfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PatientAlreadyExistsException.class)
	public ResponseEntity<ErrorInfo> patinetAlreadyExistsExceptionHandler(PatientAlreadyExistsException ex,
			HttpServletRequest httpServletRequest) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				ex.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorInfo> userNotFoundExceptionHandler(IdNotFoundException ex,
			HttpServletRequest httpServletRequest) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), ex.getMessage(),
				httpServletRequest.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(Exception e, HttpServletRequest request) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				e.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
