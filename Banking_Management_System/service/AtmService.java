package com.qsp.Banking_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.qsp.Banking_Management_System.dao.AtmDao;
import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.exception.AtmIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@Service
public class AtmService {
	@Autowired
	AtmDao atmDao;
	
	@Autowired
	ResponseStructure<Atm> responseStructure;
	
	@Autowired
	ResponseStructureList<Atm> responseStructureList;
	
	public ResponseStructure<Atm> saveAtm(Atm atm) {
		responseStructure.setMessage("SUCESSFULLY ATM INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(atmDao.saveAtm(atm));
		return responseStructure;
	}
	
	public ResponseStructure<Atm> updateAtm(int oldId,Atm newatm) {
		Atm atm= atmDao.fetchAtm(oldId);
		if(atm!=null) {
		responseStructure.setMessage("SUCESSFULLY ADDRESS UPDATE IN DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(atmDao.updateAtm(oldId, newatm));
		return responseStructure;
		}else {
			throw new AtmIdNotFound();
		}
	}
	
	public ResponseStructure<Atm> fetchAtm(int id) {
		Atm atm= atmDao.fetchAtm(id);
		if(atm!=null) {
			responseStructure.setMessage("SUCESSFULLY ATM FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(atmDao.fetchAtm(id));
			return responseStructure;
		}else {
			throw new AtmIdNotFound();
		}
	}
	
	public ResponseStructureList<Atm> fetchAllAtms(){
		responseStructureList.setMessage("SUCESSFULLY ATMS FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(atmDao.fetchAllAtms());
		return responseStructureList;
	}
	
	public ResponseStructure<Atm> deleteAtm(int id) {
		Atm atm= atmDao.fetchAtm(id);
		if(atm!=null) {
		responseStructure.setMessage("SUCESSFULLY ATM DELETED FROM DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(atmDao.deleteAtm(id));
		return responseStructure;
		}else {
			throw new AtmIdNotFound();
		}
	}
}
