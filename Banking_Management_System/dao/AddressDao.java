package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Address;
import com.qsp.Banking_Management_System.repo.AddressRepo;


@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Address updateAddress(int oldId,Address newaddress) {
		newaddress.setAddressId(oldId);
		addressRepo.save(newaddress);
		return newaddress;
	}
	
	public Address fetchAddress(int id) {
		 Optional<Address>  address = addressRepo.findById(id);
			if(address.isPresent()) {
				return address.get();
			} else {
				return null;
			}
	}
	
	public List<Address> fetchAllAddresses(){
		return addressRepo.findAll();
	}
	
	public Address deleteAddress(int id) {
	Address address = addressRepo.findById(id).get();
	addressRepo.delete(address);
	return address;
	}
}
