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
import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.service.CustomerService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseStructure<Customer> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestParam int oldId,@RequestBody Customer newcustomer) {
		newcustomer.setCustomerId(oldId);
		customerService.saveCustomer(newcustomer);
		return newcustomer;
	}
	
	@GetMapping("/fetchCustomerById")
	public ResponseStructure<Customer> fetchCustomer(@RequestParam int id) {
		return customerService.fetchCustomer(id);
	}
	
	@GetMapping("/fetchAllCustomers")
	public ResponseStructureList<Customer> fetchAllCustomers(){
		return customerService.fetchAllCustomers();
	}
	
	@DeleteMapping("/deleteCustomer")
	public ResponseStructure<Customer> deleteCustomer(@RequestParam int id) {
	ResponseStructure<Customer> customer = customerService.fetchCustomer(id);
	customerService.deleteCustomer(id);
	return customer;
	}
	
	
	@PutMapping("/addExistingLoanToExistingCustomer")
	public Customer addExistingLoanToExistingCustomer(@RequestParam int loanId,@RequestParam int customerId) {
		return customerService.addExistingLoanToExistingCustomer(loanId, customerId);
	}
	
	@PutMapping("/addNewLoanToExistingCustomer")
	public Customer addNewLoanToExistingCustomer(@RequestParam int customerId,@RequestBody Loan newLoan) {
		return 	customerService.addNewLoanToExistingCustomer(customerId, newLoan);
	}
	
	@PutMapping("/addExistingCardToExistingCustomer")
	public Customer addExistingCardToExistingCustomer(@RequestParam int cardId,@RequestParam int customerId) {
		return customerService.addExistingCardToExistingCustomer(cardId, customerId);	
	}
	
	@PutMapping("/addNewCardToExistingCustomer")
	public Customer addNewCardToExistingCustomer(@RequestParam int customerId,@RequestBody Card newCard) {
		return customerService.addNewCardToExistingCustomer(customerId, newCard);
	}
	
	@PutMapping("/addExistingAccountToExistingCustomer")
	public Customer addExistingAccountToExistingCustomer(@RequestParam int accountId,@RequestParam int customerId) {
		return customerService.addExistingAccountToExistingCustomer(accountId, customerId);
	}
	
	@PutMapping("/addNewAccountToExistingCustomer")
	public Customer addNewAccountToExistingCustomer(@RequestParam int customerId,@RequestBody Account newAccount) {
		return customerService.addNewAccountToExistingCustomer(customerId, newAccount);	
	}
	
}
