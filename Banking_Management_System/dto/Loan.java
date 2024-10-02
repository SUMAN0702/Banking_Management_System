package com.qsp.Banking_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;
	private long longNumber;
	private double loanTenure;
	private double loanInterestRate;
	private String loanType;
	private double loanMaxinmumAmount;
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public long getLongNumber() {
		return longNumber;
	}
	public void setLongNumber(long longNumber) {
		this.longNumber = longNumber;
	}
	public double getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(double loanTenure) {
		this.loanTenure = loanTenure;
	}
	public double getLoanInterestRate() {
		return loanInterestRate;
	}
	public void setLoanInterestRate(double loanInterestRate) {
		this.loanInterestRate = loanInterestRate;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanMaxinmumAmount() {
		return loanMaxinmumAmount;
	}
	public void setLoanMaxinmumAmount(double loanMaxinmumAmount) {
		this.loanMaxinmumAmount = loanMaxinmumAmount;
	}
	
}
