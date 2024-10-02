package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.repo.AccountRepo;


@Repository
public class AccountDao {
	@Autowired
	AccountRepo accountRepo;
	
	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}
	
	public Account updateAccount(int oldId,Account newaccount) {
		newaccount.setAccountId(oldId);
		accountRepo.save(newaccount);
		return newaccount;
	}
	
	public Account fetchAccount(int id) {
		 Optional<Account>  account = accountRepo.findById(id);
			if(account.isPresent()) {
				return account.get();
			} else {
				return null;
			}
	}
	
	public List<Account> fetchAllAccounts(){
		return accountRepo.findAll();
	}
	
	public Account deleteAccount(int id) {
	Account account = accountRepo.findById(id).get();
	accountRepo.delete(account);
	return account;
	}
}
