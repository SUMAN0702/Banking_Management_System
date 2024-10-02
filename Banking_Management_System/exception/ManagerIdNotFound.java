package com.qsp.Banking_Management_System.exception;

public class ManagerIdNotFound extends RuntimeException{

private String message="Manager not present in DB";
	
	public String getMessage() {
		return message;
	}
}
