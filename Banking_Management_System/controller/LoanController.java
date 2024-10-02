package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.service.LoanService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;
@RestController
public class LoanController {
	@Autowired
	LoanService loanService;
	
	@PostMapping("/saveLoan")
	public ResponseStructure<Loan> saveLoan(@RequestBody Loan loan) {
		return loanService.saveLoan(loan);
	}
	
	@PutMapping("/updateLoan")
	public Loan updateLoan(@RequestParam int oldId,@RequestBody Loan newloan) {
		newloan.setLoanId(oldId);
		loanService.saveLoan(newloan);
		return newloan;
	}
	
	@GetMapping("/fetchLoanById")
	public ResponseStructure<Loan> fetchLoan(@RequestParam int id) {
		return loanService.fetchLoan(id);
	}
	
	@GetMapping("/fetchAllLoans")
	public ResponseStructureList<Loan> fetchAllLoans(){
		return loanService.fetchAllLoans();
	}
	
	@DeleteMapping("/deleteLoan")
	public ResponseStructure<Loan> deleteLoan(@RequestParam int id) {
	ResponseStructure<Loan> loan = loanService.fetchLoan(id);
	loanService.deleteLoan(id);
	return loan;
	}
}
