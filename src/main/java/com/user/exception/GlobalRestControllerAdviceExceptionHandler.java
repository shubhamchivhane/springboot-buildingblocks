package com.user.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {

	@ExceptionHandler(UserNameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomeErrorDetails customErrorDetails(UserNameNotFoundException e)
	{
		return new CustomeErrorDetails(new Date(),"Not Found Exception rest",e.getMessage());
	}
}
