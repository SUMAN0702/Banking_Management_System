package com.qsp.Banking_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.ManagerDao;
import com.qsp.Banking_Management_System.dto.Manager;
import com.qsp.Banking_Management_System.exception.ManagerIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;
@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	ResponseStructure<Manager> responseStructure;
	
	@Autowired
	ResponseStructureList<Manager> responseStructureList;
	
	public ResponseStructure<Manager> saveManager(Manager manager) {
		responseStructure.setMessage("SUCESSFULLY MANAGER INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(managerDao.saveManager(manager));
		return responseStructure;
	}
	
	public ResponseStructure<Manager> updateManager(int oldId,Manager newmanager) {
		Manager manager= managerDao.fetchManager(oldId);
		if(manager!=null) {
			responseStructure.setMessage("SUCESSFULLY MANAGER updted FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(managerDao.updateManager(oldId, newmanager));
			return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
			
	}
	
	public ResponseStructure<Manager> fetchManager(int id) {
		Manager manager= managerDao.fetchManager(id);
		if(manager!=null) {
			responseStructure.setMessage("SUCESSFULLY MANAGER FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(managerDao.fetchManager(id));
			return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
			
	}
	
	public ResponseStructureList<Manager> fetchAllManagers(){
		responseStructureList.setMessage("SUCESSFULLY MANAGERS FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(managerDao.fetchAllManagers());
		return responseStructureList;
	}
	
	public ResponseStructure<Manager> deleteManager(int id) {
		Manager manager= managerDao.fetchManager(id);
		if(manager!=null) {
		responseStructure.setMessage("SUCESSFULLY MANAGER DELETED FROM DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(managerDao.deleteManager(id));
		return responseStructure;
		}else {
			throw new ManagerIdNotFound();
		}
			
	}
}
