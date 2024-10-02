package com.qsp.Banking_Management_System.exception;

public class CustomerIdNotFound extends RuntimeException{

private String message="Customer not present in DB";
	
	public String getMessage() {
		return message;
	}
}
