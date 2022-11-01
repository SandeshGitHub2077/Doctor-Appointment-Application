package com.cg.doctor.exceptions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.doctor.controllers.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ErrorInfo> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ie, HttpServletRequest req) {
		StringBuilder message = new StringBuilder();
		List<ObjectError> listErrors = ie.getAllErrors();
		for(ObjectError obj : listErrors) {
			FieldError fe = (FieldError) obj;
			message.append(fe.getField() + "=" + fe.getDefaultMessage()+";") ;
		}
		ErrorInfo rinfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), message.toString(),
				req.getRequestURI());
		return new ResponseEntity<>(rinfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AvailabilityExistsException.class)
	ResponseEntity<ErrorInfo> availabilityExistsExceptionHandler(AvailabilityExistsException exception,
			HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AvailabilityNotFoundException.class)
	ResponseEntity<ErrorInfo> availabilityNotFoundExceptionHandler(AvailabilityNotFoundException exception,
			HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DoctorAlreadyPresentException.class)
	ResponseEntity<ErrorInfo> doctorAlreadyPresentExceptionHandler(DoctorAlreadyPresentException exception,
			HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DoctorNotFoundException.class)
	ResponseEntity<ErrorInfo> doctNotFoundExceptionHandler(DoctorNotFoundException exception,
			HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdnotFoundException.class)
	ResponseEntity<ErrorInfo> idNotFoundExceptionHandler(IdnotFoundException exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SpecialityNotFoundException.class)
	ResponseEntity<ErrorInfo> specialityNotFoundExceptionHandler(SpecialityNotFoundException exception,
			HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(Exception exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

}
