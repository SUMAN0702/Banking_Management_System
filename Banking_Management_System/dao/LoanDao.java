package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.repo.LoanRepo;


@Repository
public class LoanDao {
	@Autowired
	LoanRepo loanRepo;
	
	public Loan saveLoan(Loan loan) {
		return loanRepo.save(loan);
	}
	
	public Loan updateLoan(int oldId,Loan newloan) {
		newloan.setLoanId(oldId);
		loanRepo.save(newloan);
		return newloan;
	}
	
	public Loan fetchLoan(int id) {
		 Optional<Loan>  loan = loanRepo.findById(id);
			if(loan.isPresent()) {
				return loan.get();
			} else {
				return null;
			}
	}
	
	public List<Loan> fetchAllLoans(){
		return loanRepo.findAll();
	}
	
	public Loan deleteLoan(int id) {
	Loan loan = loanRepo.findById(id).get();
	loanRepo.delete(loan);
	return loan;
	}
}
