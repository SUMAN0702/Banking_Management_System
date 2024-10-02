package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.service.BranchService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	
	@PutMapping("/updateBranch")
	public Branch updateBranch(@RequestParam int oldId,@RequestBody Branch newbranch) {
		newbranch.setBranchId(oldId);
		branchService.saveBranch(newbranch);
		return newbranch;
	}
	
	@GetMapping("/fetchBranchById")
	public ResponseStructure<Branch> fetchBranch(@RequestParam int id) {
		return branchService.fetchBranch(id);
	}
	
	@GetMapping("/fetchAllBranches")
	public ResponseStructureList<Branch> fetchAllBranches(){
		return branchService.fetchAllBranches();
	}
	
	@DeleteMapping("/deleteBranch")
	public ResponseStructure<Branch> deleteBranch(@RequestParam int id) {
	ResponseStructure<Branch> branch = branchService.fetchBranch(id);
	branchService.deleteBranch(id);
	return branch;
	}

	@PutMapping("/addExistingManagerToExistingBranch")
	public Branch addExistingManagerToExistingBranch(@RequestParam int branchId,@RequestParam int managerId) {
		return branchService.addExistingManagerToExistingBranch(branchId, managerId);
	}
	
	@PutMapping("/addExistingAddressToExistingBranch")
	public Branch addExistingAddressToExistingBranch(@RequestParam int branchId,@RequestParam int addressId) {
		return branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}
	
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public Branch addExistingEmployeeToExistingBranch(@RequestParam int branchId,@RequestParam int employeeId) {
		return branchService.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}
	
	@PutMapping("/addNewEmployeeToExistingBranch")
	public Branch addNewEmployeeToExistingBranch(@RequestParam int branchId,@RequestBody Employee newEmployee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}
	
	@PutMapping("/addExistingCustomerToExistingBranch")
	public Branch addExistingCustomerToExistingBranch(@RequestParam int branchId,@RequestParam int customerId) {
		return branchService.addExistingCustomerToExistingBranch(branchId, customerId);
	}
	
	@PutMapping("/addNewCustomerToExistingBranch")
	public Branch addNewCustomerToExistingBranch(@RequestParam int branchId,@RequestBody Customer newCustomer) {
		return branchService.addNewCustomerToExistingBranch(branchId, newCustomer);		
	}
	

	
}
