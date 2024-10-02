package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Account;
import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.dto.Customer;
import com.qsp.Banking_Management_System.dto.Loan;
import com.qsp.Banking_Management_System.repo.CustomerRepo;


@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	CardDao cardDao;
	
	@Autowired
	AccountDao accountDao;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer updateCustomer(int oldId,Customer newcustomer) {
		newcustomer.setCustomerId(oldId);
		customerRepo.save(newcustomer);
		return newcustomer;
	}
	
	public Customer fetchCustomer(int id) {
		 Optional<Customer>  customer = customerRepo.findById(id);
			if(customer.isPresent()) {
				return customer.get();
			} else {
				return null;
			}
	}
	
	public List<Customer> fetchAllCustomers(){
		return customerRepo.findAll();
	}
	
	public Customer deleteCustomer(int id) {
	Customer customer = customerRepo.findById(id).get();
	customerRepo.delete(customer);
	return customer;
	}
	
	public Customer addExistingLoanToExistingCustomer(int loanId,int customerId) {
		Customer customer=fetchCustomer(customerId);
		Loan loan=loanDao.fetchLoan(customerId);
		List<Loan> list=customer.getLoans();
		list.add(loan);
		customer.setLoans(list);
		return saveCustomer(customer);		
	}
	

	public Customer addNewLoanToExistingCustomer(int customerId,Loan newLoan) {
		Customer customer=fetchCustomer(customerId);
		List<Loan> list=customer.getLoans();
		list.add(newLoan);
		customer.setLoans(list);
		return saveCustomer(customer);		
	}
	

	public Customer addExistingCardToExistingCustomer(int cardId,int customerId) {
		Customer customer=fetchCustomer(customerId);
		Card card=cardDao.fetchCard(cardId);
		List<Card> list=customer.getCards();
		list.add(card);
		customer.setCards(list);
		return saveCustomer(customer);		
	}
	

	public Customer addNewCardToExistingCustomer(int customerId, Card newCard) {
		Customer customer=fetchCustomer(customerId);
		List<Card> list=customer.getCards();
		list.add(newCard);
		customer.setCards(list);
		return saveCustomer(customer);		
	}
	
	public Customer addExistingAccountToExistingCustomer(int accountId,int customerId) {
		Customer customer=fetchCustomer(customerId);
		Account account=accountDao.fetchAccount(accountId);
		List<Account> list=customer.getAccounts();
		list.add(account);
		customer.setAccounts(list);
		return saveCustomer(customer);		
	}
	

	public Customer addNewAccountToExistingCustomer(int customerId, Account newAccount) {
		Customer customer=fetchCustomer(customerId);
		List<Account> list=customer.getAccounts();
		list.add(newAccount);
		customer.setAccounts(list);
		return saveCustomer(customer);		
	}
	
	
	
}
