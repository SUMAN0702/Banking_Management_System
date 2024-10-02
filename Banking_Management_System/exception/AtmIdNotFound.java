package com.qsp.Banking_Management_System.exception;

public class AtmIdNotFound extends RuntimeException{

private String message="Atm not present in DB";
	
	public String getMessage() {
		return message;
	}
}
