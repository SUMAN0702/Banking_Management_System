package com.qsp.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.CustomerDao;
import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.exception.CustomerIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	ResponseStructure<Customer> responseStructure;

	@Autowired
	ResponseStructureList<Customer> responseStructureList;

	public ResponseStructure<Customer> saveCustomer(Customer customer) {
		responseStructure.setMessage("SUCESSFULLY CUSTOMER INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		return responseStructure;
	}

	public ResponseStructure<Customer> updateCustomer(int oldId, Customer newcustomer) {
		Customer customer = customerDao.fetchCustomer(oldId);
		if (customer != null) {
			responseStructure.setMessage("SUCESSFULLY CARD UPDADTE IN DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.updateCustomer(oldId, newcustomer));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}

	}

	public ResponseStructure<Customer> fetchCustomer(int id) {
		Customer customer = customerDao.fetchCustomer(id);
		if (customer != null) {
			responseStructure.setMessage("SUCESSFULLY CUSTOMER FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(customerDao.fetchCustomer(id));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructureList<Customer> fetchAllCustomers() {
		responseStructureList.setMessage("SUCESSFULLY CUSTOMERS FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(customerDao.fetchAllCustomers());
		return responseStructureList;
	}

	public ResponseStructure<Customer> deleteCustomer(int id) {
		Customer customer = customerDao.fetchCustomer(id);
		if (customer != null) {

			responseStructure.setMessage("SUCESSFULLY CUSTOMER DELETED FROM DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.deleteCustomer(id));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public Customer addExistingLoanToExistingCustomer(int loanId, int customerId) {
		return customerDao.addExistingLoanToExistingCustomer(loanId, customerId);
	}

	public Customer addNewLoanToExistingCustomer(int customerId, Loan newLoan) {
		return customerDao.addNewLoanToExistingCustomer(customerId, newLoan);
	}

	public Customer addExistingCardToExistingCustomer(int cardId, int customerId) {
		return customerDao.addExistingCardToExistingCustomer(cardId, customerId);
	}

	public Customer addNewCardToExistingCustomer(int customerId, Card newCard) {
		return customerDao.addNewCardToExistingCustomer(customerId, newCard);
	}

	public Customer addExistingAccountToExistingCustomer(int accountId, int customerId) {
		return customerDao.addExistingAccountToExistingCustomer(accountId, customerId);
	}

	public Customer addNewAccountToExistingCustomer(int customerId, Account newAccount) {
		return customerDao.addNewAccountToExistingCustomer(customerId, newAccount);
	}

}
