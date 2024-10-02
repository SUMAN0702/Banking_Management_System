package com.qsp.Banking_Management_System.exception;

public class BranchIdNotFound extends RuntimeException{

private String message="Branch not present in DB";
	
	public String getMessage() {
		return message;
	}
}
