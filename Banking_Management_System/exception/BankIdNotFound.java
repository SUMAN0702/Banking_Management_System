package com.qsp.Banking_Management_System.exception;

public class BankIdNotFound extends RuntimeException{
	
private String message="Bank not present in DB";
	
	public String getMessage() {
		return message;
	}
}
