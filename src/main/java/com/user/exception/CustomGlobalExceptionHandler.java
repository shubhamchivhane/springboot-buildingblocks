package com.user.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomeErrorDetails customError=new CustomeErrorDetails(new Date(),
				"From handleMethodArgumentNotValid in Customer Global exception",ex.getMessage());
		return new ResponseEntity<>(customError,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomeErrorDetails customError=new CustomeErrorDetails(new Date(),
				"From handleMethodArgumentNotValid in Customer Global exception-Method type not allowed",ex.getMessage());
		return new ResponseEntity<>(customError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNameNotFoundException.class)
	protected ResponseEntity<Object> handleUserNameNotFoundException(
			UserNameNotFoundException ex, WebRequest request) {
		CustomeErrorDetails customError=new CustomeErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(customError,HttpStatus.NOT_FOUND);
	}
	
}
