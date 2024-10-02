package com.qsp.Banking_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Banking_Management_System.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
