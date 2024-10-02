package com.qsp.Banking_Management_System.exception;

public class CardIdNotFound extends RuntimeException{

private String message="Card not present in DB";
	
	public String getMessage() {
		return message;
	}
}
