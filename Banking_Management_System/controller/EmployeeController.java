package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.service.EmployeeService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestParam int oldId,@RequestBody Employee newemployee) {
		newemployee.setEmployeeId(oldId);
		employeeService.saveEmployee(newemployee);
		return newemployee;
	}
	
	@GetMapping("/fetchEmployeeById")
	public ResponseStructure<Employee> fetchEmployee(@RequestParam int id) {
		return employeeService.fetchEmployee(id);
	}
	
	@GetMapping("/fetchAllEmployees")
	public ResponseStructureList<Employee> fetchAllEmployees(){
		return employeeService.fetchAllEmployees();
	}
	
	@DeleteMapping("/deleteEmployee")
	public ResponseStructure<Employee> deleteEmployee(@RequestParam int id) {
	ResponseStructure<Employee> employee = employeeService.fetchEmployee(id);
	employeeService.deleteEmployee(id);
	return employee;
	}
}
