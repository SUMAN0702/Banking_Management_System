package com.qsp.Banking_Management_System.exception;

public class AddressIdNotFound extends RuntimeException{
	
private String message="Address not present in DB";
	
	public String getMessage() {
		return message;
	}
}
