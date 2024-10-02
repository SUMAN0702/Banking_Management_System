package com.qsp.Banking_Management_System.exception;

public class LoanIdNotFound extends RuntimeException{
	
private String message="Loan not present in DB";
	
	public String getMessage() {
		return message;
	}
}
