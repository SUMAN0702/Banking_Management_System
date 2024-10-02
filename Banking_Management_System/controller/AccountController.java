package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.service.AccountService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@PostMapping("/saveAccount")
	public ResponseStructure<Account> saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}
	
	@PutMapping("/updateAccount")
	public Account updateAccount(@RequestParam int oldId,@RequestBody Account newaccount) {
		newaccount.setAccountId(oldId);
		accountService.saveAccount(newaccount);
		return newaccount;
	}
	
	@GetMapping("/fetchAccountById")
	public ResponseStructure<Account> fetchAccount(@RequestParam int id) {
		return accountService.fetchAccount(id);
	}
	
	@GetMapping("/fetchAllAccounts")
	public ResponseStructureList<Account> fetchAllAccounts(){
		return accountService.fetchAllAccounts();
	}
	
	@DeleteMapping("/deleteAccount")
	public ResponseStructure<Account> deleteAccount(@RequestParam int id) {
	ResponseStructure<Account> account = accountService.fetchAccount(id);
	accountService.deleteAccount(id);
	return account;
	}
}
