package com.qsp.Banking_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.LoanDao;
import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.exception.LoanIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@Service
public class LoanService {
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	ResponseStructure<Loan> responseStructure;
	
	@Autowired
	ResponseStructureList<Loan> responseStructureList;
	
	public ResponseStructure<Loan> saveLoan(Loan loan) {
		responseStructure.setMessage("SUCESSFULLY LOAN INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(loanDao.saveLoan(loan));
		return responseStructure;
	}
	
	public ResponseStructure<Loan> updateLoan(int oldId,Loan newloan) {
		Loan loan= loanDao.fetchLoan(oldId);
		if(loan!=null) {
			responseStructure.setMessage("SUCESSFULLY LOAN UPDATED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(loanDao.updateLoan(oldId, newloan));
			return responseStructure;
		}else {
			throw new LoanIdNotFound();
		}
		
	}
	
	public ResponseStructure<Loan> fetchLoan(int id) {
		Loan loan= loanDao.fetchLoan(id);
		if(loan!=null) {
			responseStructure.setMessage("SUCESSFULLY LOAN FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(loanDao.fetchLoan(id));
			return responseStructure;
		}else {
			throw new LoanIdNotFound();
		}
	}
	
	public ResponseStructureList<Loan> fetchAllLoans(){
		responseStructureList.setMessage("SUCESSFULLY LOANS FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(loanDao.fetchAllLoans());
		return responseStructureList;
	}
	
	public ResponseStructure<Loan> deleteLoan(int id) {
		Loan loan= loanDao.fetchLoan(id);
		if(loan!=null) {
		responseStructure.setMessage("SUCESSFULLY LOAN DELETED FROM DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(loanDao.deleteLoan(id));
		return responseStructure;
		}else {
			throw new LoanIdNotFound();
		}
	}
}
