package com.qsp.Banking_Management_System.exception;

public class AccountIdNotFound extends RuntimeException{

private String message="Account not present in DB";
	
	public String getMessage() {
		return message;
	}
}
