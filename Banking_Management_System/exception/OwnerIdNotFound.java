package com.qsp.Banking_Management_System.exception;

public class OwnerIdNotFound extends RuntimeException{

	private String message="Owner not present in DB";
	
	public String getMessage() {
		return message;
	}
}
