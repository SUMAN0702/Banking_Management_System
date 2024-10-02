package com.qsp.Banking_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.EmployeeDao;
import com.qsp.Banking_Management_System.dto.Employee;
import com.qsp.Banking_Management_System.exception.EmployeeIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	ResponseStructure<Employee> responseStructure;
	
	@Autowired
	ResponseStructureList<Employee> responseStructureList;
	
	public ResponseStructure<Employee> saveEmployee(Employee employee) {
		responseStructure.setMessage("SUCESSFULLY EMPLOYEE INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return responseStructure;
	}
	
	public ResponseStructure<Employee> updateEmployee(int oldId,Employee newemployee) {
		Employee employee= employeeDao.fetchEmployee(oldId);
		if(employee!=null) {
		responseStructure.setMessage("SUCESSFULLY EMPLOYEE updated IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.updateEmployee(oldId, newemployee));
		return responseStructure;
	
	}else {
		throw new EmployeeIdNotFound();
	}
	}

	
	public ResponseStructure<Employee> fetchEmployee(int id) {
		Employee employee= employeeDao.fetchEmployee(id);
		if(employee!=null) {
			responseStructure.setMessage("SUCESSFULLY EMPLOYEE FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(employeeDao.fetchEmployee(id));
			return responseStructure;
		}else {
			throw new EmployeeIdNotFound();
		}
	}
	
	public ResponseStructureList<Employee> fetchAllEmployees(){
		responseStructureList.setMessage("SUCESSFULLY EMPLOYEES FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(employeeDao.fetchAllEmployees());
		return responseStructureList;
	}
	
	public ResponseStructure<Employee> deleteEmployee(int id) {
		Employee employee = employeeDao.fetchEmployee(id);
		if(employee !=null) {
	
		responseStructure.setMessage("SUCESSFULLY EMPLOYEE DELETED FROM DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.deleteEmployee(id));
		return responseStructure;
	}else {
		throw new EmployeeIdNotFound();
	}
	}
}
