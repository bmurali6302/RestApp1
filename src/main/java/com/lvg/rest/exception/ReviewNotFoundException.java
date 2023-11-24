package com.lvg.rest.exception;

public class ReviewNotFoundException extends RuntimeException{
	String message;
	ReviewNotFoundException(){}
	public ReviewNotFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public String toString() {
		return "ReviewNotFoundException : "+message;
	}

}
