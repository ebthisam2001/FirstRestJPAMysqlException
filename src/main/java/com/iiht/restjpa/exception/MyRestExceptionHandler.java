package com.iiht.restjpa.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyRestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value={NullPointerException.class})
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	protected ResponseEntity<Object> errorHandler(NullPointerException e, WebRequest req){
		MyErrorResponse error=new MyErrorResponse();
		error.setErrorCode("406");
		error.setMessage(e.getMessage());
		error.setTime(new Date());
		return handleExceptionInternal(e,error,new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE,req);//5 arguments
	}
	@ExceptionHandler(value={InvalidValueException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> errorHandler(InvalidValueException e, WebRequest req){
		MyErrorResponse error=new MyErrorResponse();
		error.setErrorCode("404");
		error.setMessage(e.getMessage());
		error.setTime(new Date());
		return handleExceptionInternal(e,error,new HttpHeaders(), HttpStatus.BAD_REQUEST,req);//5 arguments
	}
	@ExceptionHandler(value={Exception.class})
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	protected ResponseEntity<Object> errorHandler(Exception e, WebRequest req){
		MyErrorResponse error=new MyErrorResponse();
		error.setErrorCode("405");
		error.setMessage(e.getMessage());
		error.setTime(new Date());
		return handleExceptionInternal(e,error,new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE,req);//5 arguments
	}
	
	
	
	

}
