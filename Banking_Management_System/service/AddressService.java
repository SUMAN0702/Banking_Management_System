package com.qsp.Banking_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.AddressDao;
import com.qsp.Banking_Management_System.dto.Address;
import com.qsp.Banking_Management_System.exception.AddressIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	@Autowired
	ResponseStructureList<Address> responseStructureList;
	
	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setMessage("SUCESSFULLY ADDRESS INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return responseStructure;
	}
	
	public ResponseStructure<Address> updateAddress(int oldId,Address newaddress) {
		Address address= addressDao.fetchAddress(oldId);
		if(address!=null) {
		responseStructure.setMessage("SUCESSFULLY ADDRESS UPDATE IN DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.updateAddress(oldId, newaddress));
		return responseStructure;
		}else {
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseStructure<Address> fetchAddress(int id) {
		Address address= addressDao.fetchAddress(id);
		if(address!=null) {
			responseStructure.setMessage("SUCESSFULLY ADDRESS FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(addressDao.fetchAddress(id));
			return responseStructure;
		}else {
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseStructureList<Address> fetchAllAddresses(){
		responseStructureList.setMessage("SUCESSFULLY ADDRESSES FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(addressDao.fetchAllAddresses());
		return responseStructureList;
	}
	
	public ResponseStructure<Address> deleteAddress(int id) {
		Address address= addressDao.fetchAddress(id);
		if(address!=null) {
		responseStructure.setMessage("SUCESSFULLY ADDRESS DELETED FROM DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.deleteAddress(id));
		return responseStructure;
		}else {
			throw new AddressIdNotFound();
		}
	}
}
