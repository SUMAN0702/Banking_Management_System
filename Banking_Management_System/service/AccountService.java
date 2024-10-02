package com.qsp.Banking_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.AccountDao;
import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.exception.AccountIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;


@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	ResponseStructure<Account> responseStructure;
	
	@Autowired
	ResponseStructureList<Account> responseStructureList;
	
	public ResponseStructure<Account> saveAccount(Account account) {
		responseStructure.setMessage("SUCESSFULLY ACCOUNT INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(accountDao.saveAccount(account));
		return responseStructure;
	}
	
	public ResponseStructure<Account> updateAccount(int oldId,Account newaccount) {
		responseStructure.setMessage("SUCESSFULLY ACCOUNT UPDATED IN DB");
		responseStructure.setStatusCode(HttpStatus.OK  .value());
		responseStructure.setData(accountDao.updateAccount(oldId, newaccount));
		return responseStructure;
		
	}
	
	public ResponseStructure<Account> fetchAccount(int id) {
		Account account= accountDao.fetchAccount(id);
		if(account!=null) {
			responseStructure.setMessage("SUCESSFULLY ACCOUNT FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(accountDao.fetchAccount(id));
			return responseStructure;
		}else {
			throw new AccountIdNotFound();
		}
	}
	
	public ResponseStructureList<Account> fetchAllAccounts(){
		responseStructureList.setMessage("SUCESSFULLY ACCOUNTS FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(accountDao.fetchAllAccounts());
		return responseStructureList;
	}
	
	public ResponseStructure<Account> deleteAccount(int id) {
		Account account= accountDao.fetchAccount(id);
		if(account!=null) {
		responseStructure.setMessage("SUCESSFULLY ACCOUNT DELETED FROM DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(accountDao.deleteAccount(id));
		return responseStructure;
		}else {
			throw new AccountIdNotFound();
		}
	}
}
