package com.qsp.Banking_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.OwnerDao;
import com.qsp.Banking_Management_System.dto.Owner;
import com.qsp.Banking_Management_System.exception.OwnerIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@Service
public class OwnerService {
	@Autowired
	OwnerDao ownerDao;
	
	@Autowired
	ResponseStructure<Owner> responseStructure;
	
	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	
	public ResponseStructure<Owner> saveOwner(Owner owner) {
		responseStructure.setMessage("SUCESSFULLY OWNER INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return responseStructure;
	}
	
	public ResponseStructure<Owner> updateOwner(int oldId,Owner newowner) {
		Owner owner=ownerDao.fetchOwner(oldId);
		if(owner!=null) {
		responseStructure.setMessage("SUCESSFULLY OWNER updated FROM DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(ownerDao.updateOwner(oldId, newowner));
		return responseStructure;
	}else {
		throw new OwnerIdNotFound();
	}
		
	}
	
	public ResponseStructure<Owner> fetchOwner(int id) {
		
		Owner owner=ownerDao.fetchOwner(id);
		if(owner!=null) {
		responseStructure.setMessage("SUCESSFULLY OWNER FETCHED FROM DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(ownerDao.fetchOwner(id));
		return responseStructure;
	}else {
		throw new OwnerIdNotFound();
	}
		
	}
	
	public ResponseStructureList<Owner> fetchAll(){
		responseStructureList.setMessage("SUCESSFULLY OWNERS FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(ownerDao.fetchAllOwners());
		return responseStructureList;
	}
	
	public ResponseStructure<Owner> deleteOwner(int id) {
		Owner owner=ownerDao.fetchOwner(id);
		if(owner!=null) {
		responseStructure.setMessage("SUCESSFULLY OWNER DELETED FROM DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.deleteOwner(id));
		return responseStructure;
		}else {
			throw new OwnerIdNotFound();
		}
	}
	
	public Owner addExistingBankToExistingOwner(int bankId,int ownerId) {
		return ownerDao.addExistingBankToExistingOwner(bankId, ownerId);
		
	}
		

}
