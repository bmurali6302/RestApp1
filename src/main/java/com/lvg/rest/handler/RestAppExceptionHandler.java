package com.lvg.rest.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lvg.rest.exception.ProductNotFoundException;
import com.lvg.rest.exception.ReviewNotFoundException;

@ControllerAdvice  //its an global exceptionhandler
public class RestAppExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ProductNotFoundException.class)
	public  ResponseEntity<String> productNotFoundExceptionHandler(ProductNotFoundException ex) {
		System.out.println(ex);
		return new ResponseEntity<String>("Product Not Found",HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(ReviewNotFoundException.class)
	public ResponseEntity<String> reviewNotFoundExceptionHandler(ReviewNotFoundException ex) { 
		System.out.println(ex);
		return new ResponseEntity<String>("Review Not Found",HttpStatus.NO_CONTENT);
	}
	

}
