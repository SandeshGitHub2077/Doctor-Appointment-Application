package com.cg.appointment.exceptions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.appointment.controller.ErrorInfo;

/**
 * 
 * @author B.Rishita
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 
	 * @param exception Method Argument Not Valid Exception
	 * @param request   HttpServletrequest method
	 * @return Error Information and HttpStatus
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(MethodArgumentNotValidException exception,
			HttpServletRequest request) {
		StringBuilder message = new StringBuilder();
		List<ObjectError> listErrors = exception.getAllErrors();
		for (ObjectError obj : listErrors) {
			FieldError fe = (FieldError) obj;
			message.append(fe.getField() + "=" + fe.getDefaultMessage() + ";");
		}
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				message.toString(), request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param exception IDNotFoundException
	 * @param request   HttpServletrequest method
	 * @return Error Information and HttpStatus
	 */
	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(IdNotFoundException exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param exception AppointmentNotRegisteredException
	 * @param request   HttpServletrequest method
	 * @return Error Information and HttpStatus
	 */
	@ExceptionHandler(AppointmentNotRegisteredException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(AppointmentNotRegisteredException exception,
			HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param exception AppointmentNotUpdatedException
	 * @param request   HttpServletrequest method
	 * @return Error Information and HttpStatus
	 */
	@ExceptionHandler(AppointmentNotUpdatedException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(AppointmentNotUpdatedException exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param exception DoctorNotFoundException
	 * @param request   HttpServletrequest method
	 * @return Error Information and HttpStatus
	 */
	@ExceptionHandler(DoctorNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(DoctorNotFoundException exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param exception PatientNotFoundException
	 * @param request   HttpServletrequest method
	 * @return Error Information and HttpStatus
	 */
	@ExceptionHandler(PatientNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(PatientNotFoundException exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param exception AppointmentStatusNotFoundException
	 * @param request   HttpServletrequest method
	 * @return Error Information and HttpStatus
	 */
	@ExceptionHandler(AppointmentStatusNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(AppointmentStatusNotFoundException exception,
			HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param exception AppointmentNotFoundException
	 * @param request   HttpServletrequest method
	 * @return Error Information and HttpStatus
	 */
	@ExceptionHandler(AppointmentNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(AppointmentNotFoundException exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param exception DoctorNotFoundException
	 * @param request   HttpServletrequest method
	 * @return Error Information and HttpStatus
	 */
	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(Exception exception, HttpServletRequest request) {
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	}
}
