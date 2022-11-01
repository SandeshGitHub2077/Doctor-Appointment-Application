package com.cg.admindata.exceptions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.admindata.controllers.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(MethodArgumentNotValidException exception, HttpServletRequest request) {
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

	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(IdNotFoundException exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AdminAlreadyExistException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(AdminAlreadyExistException exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(Exception exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.BAD_REQUEST);
	}

}
