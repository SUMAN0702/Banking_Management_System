package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Address;
import com.qsp.Banking_Management_System.dto.Branch;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.dto.Manager;
import com.qsp.Banking_Management_System.repo.BranchRepo;


@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	CustomerDao customerDao;
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	
	public Branch updateBranch(int oldId,Branch newbranch) {
		newbranch.setBranchId(oldId);
		branchRepo.save(newbranch);
		return newbranch;
	}
	
	public Branch fetchBranch(int id) {
		 Optional<Branch>  branch = branchRepo.findById(id);
			if(branch.isPresent()) {
				return branch.get();
			} else {
				return null;
			}
	}
	
	public List<Branch> fetchAllBranches(){
		return branchRepo.findAll();
	}
	
	public Branch deleteBranch(int id) {
	Branch branch = branchRepo.findById(id).get();
	branchRepo.delete(branch);
	return branch;
	}
	
	public Branch addExistingManagerToExistingBranch(int branchId,int managerId) {
		Manager manager=managerDao.fetchManager(managerId);
		Branch branch=fetchBranch(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}
	
	public Branch addExistingAddressToExistingBranch(int branchId,int addressId) {
		Address address = addressDao.fetchAddress(addressId);
		Branch branch=fetchBranch(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addExistingEmployeeToExistingBranch(int branchId,int employeeId) {
		Employee employee = employeeDao.fetchEmployee(employeeId);
		Branch branch = fetchBranch(branchId);
		List<Employee> list=branch.getEmployees();
		list.add(employee);
		branch.setEmployees(list);
		return saveBranch(branch);		
	}
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee newEmployee) {
		Branch branch = fetchBranch(branchId);
		List<Employee> list=branch.getEmployees();
		list.add(newEmployee);
		branch.setEmployees(list);
		return saveBranch(branch);		
	}
	

	public Branch addExistingCustomerToExistingBranch(int branchId,int customerId) {
		Customer customer=customerDao.fetchCustomer(customerId);
		Branch branch = fetchBranch(branchId);
		List<Customer> list=branch.getCustomers();
		list.add(customer);
		branch.setCustomers(list);
		return saveBranch(branch);		
	}
	public Branch addNewCustomerToExistingBranch(int branchId,Customer newCustomer) {
		Branch branch = fetchBranch(branchId);
		List<Customer> list=branch.getCustomers();
		list.add(newCustomer);
		branch.setCustomers(list);
		return saveBranch(branch);		
	}
	
}
