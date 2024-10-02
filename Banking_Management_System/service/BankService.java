package com.qsp.Banking_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.BankDao;
import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.dto.Bank;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.exception.BankIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;
@Service
public class BankService {
	@Autowired
	BankDao bankDao;
	
	@Autowired
	ResponseStructure<Bank> responseStructure;
	
	@Autowired
	ResponseStructureList<Bank> responseStructureList;
	
	public ResponseStructure<Bank> saveBank(Bank bank) {
		responseStructure.setMessage("SUCESSFULLY BANK INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bankDao.saveBank(bank));
		return responseStructure;
	}
	
	public ResponseStructure<Bank> updateBank(int oldId,Bank newbank) {
		Bank bank= bankDao.fetchBank(oldId);
		if(bank!=null) {
		responseStructure.setMessage("SUCESSFULLY BANK UPDATED IN DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.updateBank(oldId, newbank));
		return responseStructure;
		}else {
			throw new BankIdNotFound();
		}
		}
	
	public ResponseStructure<Bank> fetchBank(int id) {
	Bank bank= bankDao.fetchBank(id);
		if(bank!=null) {
			responseStructure.setMessage("SUCESSFULLY BANK FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(bankDao.fetchBank(id));
			return responseStructure;
		}else {
			throw new BankIdNotFound();
		}
	}
	
	public ResponseStructureList<Bank> fetchAllBanks(){
		responseStructureList.setMessage("SUCESSFULLY BANKS FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(bankDao.fetchAllBanks());
		return responseStructureList;
	}
	
	public ResponseStructure<Bank> deleteBank(int id) {
		Bank bank= bankDao.fetchBank(id);
		if(bank!=null) {
	
		responseStructure.setMessage("SUCESSFULLY BANK DELETED FROM DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.deleteBank(id));
		return responseStructure;
		}else {
		throw new BankIdNotFound();
		}
		
	}
	
	public Bank addExistingBranchToExistingBank(int branchId, int bankId) {
		return bankDao.addExistingBranchToExistingBank(branchId, bankId);
	}
	
	public Bank addNewBranchToExistingBank(int bankId, Branch newBranch) {
		return bankDao.addNewBranchToExistingBank(bankId, newBranch);
	}
	
	public Bank addExistingAtmToExistingBank(int atmId, int bankId) {
		return bankDao.addExistingAtmToExistingBank(atmId, bankId);
	}
	
	public Bank addNewAtmToExistingBank(int bankId, Atm newAtm) {
		return bankDao.addNewAtmToExistingBank(bankId, newAtm);
	}
}
