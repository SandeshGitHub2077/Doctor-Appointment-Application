package com.cg.adminconsumer.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.cg.adminconsumer.controllers.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<ErrorInfo> httpClientErrorExceptionHandler(HttpClientErrorException exception,
			HttpServletRequest httpServletRequest) {
		String errorMessage = exception.getResponseBodyAsString();
		Map<String, String> errors = new HashMap<>();
		errorMessage = errorMessage.substring(1, errorMessage.length() - 1);
		for (String string : errorMessage.split(",")) {
			String[] keyValuePair = string.split(":");
			errors.put(keyValuePair[0].replaceAll("\"", ""), keyValuePair[1].replaceAll("\"", ""));
		}
		ErrorInfo info = new ErrorInfo(Integer.valueOf(errors.get("httpCode")), errors.get("httpStatus"),
				errors.get("error"), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(info, exception.getStatusCode());
	}

	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(Exception exception, HttpServletRequest request) {
		ErrorInfo info = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.toString(), request.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.BAD_REQUEST);
	}
}