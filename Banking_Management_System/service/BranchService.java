package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.BranchDao;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.exception.BranchIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;


@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	
	public ResponseStructure<Branch> saveBranch(Branch branch) {
		responseStructure.setMessage("SUCESSFULLY BRANCH INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;
	}
	
	public ResponseStructure<Branch> updateBranch(int oldId,Branch newbranch) {
		Branch branch= branchDao.fetchBranch(oldId);
		if(branch!=null) {
		responseStructure.setMessage("SUCESSFULLY BANK UPDATED IN DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.updateBranch(oldId, newbranch));
		return responseStructure;
		}else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseStructure<Branch> fetchBranch(int id) {
		Branch branch= branchDao.fetchBranch(id);
		if(branch!=null) {
			responseStructure.setMessage("SUCESSFULLY BRANCH FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branchDao.fetchBranch(id));
			return responseStructure;
		}else {
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseStructureList<Branch> fetchAllBranches(){
		responseStructureList.setMessage("SUCESSFULLY BRANCHES FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(branchDao.fetchAllBranches());
		return responseStructureList;
	}
	
	public ResponseStructure<Branch> deleteBranch(int id) {
		Branch branch= branchDao.fetchBranch(id);
		if(branch!=null) {
	
		responseStructure.setMessage("SUCESSFULLY BRANCH DELETED FROM DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.deleteBranch(id));
		return responseStructure;
		}else {
			throw new BranchIdNotFound();
		}
		
	}
	
	public Branch addExistingManagerToExistingBranch(int branchId,int managerId) {
		return branchDao.addExistingManagerToExistingBranch(branchId, managerId);
	}
	
	public Branch addExistingAddressToExistingBranch(int branchId,int addressId) {
		return branchDao.addExistingAddressToExistingBranch(branchId, addressId);
	}
	
	public Branch addExistingEmployeeToExistingBranch(int branchId,int employeeId) {
		return branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}
	
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee newEmployee) {
		return branchDao.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}
	

	public Branch addExistingCustomerToExistingBranch(int branchId,int customerId) {
		return branchDao.addExistingCustomerToExistingBranch(branchId, customerId);
	}
	public Branch addNewCustomerToExistingBranch(int branchId,Customer newCustomer) {
		return branchDao.addNewCustomerToExistingBranch(branchId, newCustomer);		
	}
	


}
