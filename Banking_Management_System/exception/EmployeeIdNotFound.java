package com.qsp.Banking_Management_System.exception;

public class EmployeeIdNotFound extends RuntimeException{

private String message="Employee not present in DB";
	
	public String getMessage() {
		return message;
	}
}
