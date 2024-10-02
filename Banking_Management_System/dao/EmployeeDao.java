package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.repo.EmployeeRepo;


@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee updateEmployee(int oldId,Employee newemployee) {
		newemployee.setEmployeeId(oldId);
		employeeRepo.save(newemployee);
		return newemployee;
	}
	
	public Employee fetchEmployee(int id) {
		 Optional<Employee>  employee = employeeRepo.findById(id);
			if(employee.isPresent()) {
				return employee.get();
			} else {
				return null;
			}
	}
	
	public List<Employee> fetchAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee deleteEmployee(int id) {
	Employee employee = employeeRepo.findById(id).get();
	employeeRepo.delete(employee);
	return employee;
	}
}
