package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.qsp.Banking_Management_System.dto.Address;
import com.qsp.Banking_Management_System.service.AddressService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@PostMapping("/saveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@PutMapping("/updateAddress")
	public Address updateAddress(@RequestParam int oldId,@RequestBody Address newaddress) {
		newaddress.setAddressId(oldId);
		addressService.saveAddress(newaddress);
		return newaddress;
	}
	
	@GetMapping("/fetchAddressById")
	public ResponseStructure<Address> fetchAddress(@RequestParam int id) {
		return addressService.fetchAddress(id);
	}
	
	@GetMapping("/fetchAllAddress")
	public ResponseStructureList<Address> fetchAllAddresses(){
		return addressService.fetchAllAddresses();
	}
	
	@DeleteMapping("/deleteAddress")
	public ResponseStructure<Address> deleteAddress(@RequestParam int id) {
	ResponseStructure<Address> address = addressService.fetchAddress(id);
	addressService.deleteAddress(id);
	return address;
	}
}
