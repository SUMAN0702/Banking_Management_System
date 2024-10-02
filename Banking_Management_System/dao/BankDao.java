package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.dto.Bank;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.repo.BankRepo;


@Repository
public class BankDao {
	@Autowired
	BankRepo bankRepo;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	AtmDao atmDao;
	
	public Bank saveBank(Bank bank) {
		return bankRepo.save(bank);
	}
	
	public Bank updateBank(int oldId,Bank newbank) {
		newbank.setBankId(oldId);
		bankRepo.save(newbank);
		return newbank;
	}
	
	public Bank fetchBank(int id) {
		 Optional<Bank>  bank = bankRepo.findById(id);
			if(bank.isPresent()) {
				return bank.get();
			} else {
				return null;
			}
	}
	
	public List<Bank> fetchAllBanks(){
		return bankRepo.findAll();
	}
	
	public Bank deleteBank(int id) {
	Bank bank = bankRepo.findById(id).get();
	bankRepo.delete(bank);
	return bank;
	}
	
	public Bank addExistingBranchToExistingBank(int branchId, int bankId) {
		Branch branch = branchDao.fetchBranch(branchId);
		Bank bank = fetchBank(bankId);
		List<Branch> list = bank.getBranch();
		list.add(branch);
		bank.setBranch(list);
		return saveBank(bank);
	}
	
	public Bank addNewBranchToExistingBank(int bankId, Branch newBranch) {
		
		Bank bank = fetchBank(bankId);
		List<Branch> list = bank.getBranch();
		list.add(newBranch);
		bank.setBranch(list);
		return saveBank(bank);
	}
	
	public Bank addExistingAtmToExistingBank(int atmId, int bankId) {
		Atm atm = atmDao.fetchAtm(atmId);
		Bank bank = fetchBank(bankId);
		List<Atm> list = bank.getAtm();
		list.add(atm);
		bank.setAtm(list);
		return saveBank(bank);
	}
	
	public Bank addNewAtmToExistingBank(int bankId, Atm newAtm) {
		
		Bank bank = fetchBank(bankId);
		List<Atm> list = bank.getAtm();
		list.add(newAtm);
		bank.setAtm(list);
		return saveBank(bank);
	}
}
