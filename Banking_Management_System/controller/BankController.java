package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.dto.Bank;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.service.BankService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class BankController {
	@Autowired
	BankService bankService;
	
	@PostMapping("/saveBank")
	public ResponseStructure<Bank> saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}
	
	@PutMapping("/updateBank")
	public Bank updateBank(@RequestParam int oldId,@RequestBody Bank newbank) {
		newbank.setBankId(oldId);
		bankService.saveBank(newbank);
		return newbank;
	}
	
	@GetMapping("/fetchBankById")
	public ResponseStructure<Bank> fetchBank(@RequestParam int id) {
		return bankService.fetchBank(id);
	}
	
	@GetMapping("/fetchAllBanks")
	public ResponseStructureList<Bank> fetchAllBanks(){
		return bankService.fetchAllBanks();
	}
	
	@DeleteMapping("/deleteBank")
	public ResponseStructure<Bank> deleteBank(@RequestParam int id) {
	ResponseStructure<Bank> bank = bankService.fetchBank(id);
	bankService.deleteBank(id);
	return bank;
	}
	
	@PutMapping("/addExistingBranchToExistingBank")
	public Bank addExistingBranchToExistingBank(@RequestParam int branchId,@RequestParam int bankId) {
		return bankService.addExistingBranchToExistingBank(branchId, bankId);
	}
	
	@PutMapping("/addNewBranchToExistingBank")
	public Bank addNewBranchToExistingBank(@RequestParam int bankId,@RequestBody Branch newBranch) {
		return bankService.addNewBranchToExistingBank(bankId, newBranch);
	}
	
	@PutMapping("/addExistingAtmToExistingBank")
	public Bank addExistingAtmToExistingBank(@RequestParam int atmId,@RequestParam int bankId) {
		return bankService.addExistingAtmToExistingBank(atmId, bankId);
	}
	
	@PutMapping("/addNewAtmToExistingBank")
	public Bank addNewAtmToExistingBank(@RequestParam int bankId,@RequestBody Atm newAtm) {
		return bankService.addNewAtmToExistingBank(bankId, newAtm);
	}

}
