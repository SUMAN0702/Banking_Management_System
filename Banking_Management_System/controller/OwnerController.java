package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_Management_System.dto.Owner;
import com.qsp.Banking_Management_System.service.OwnerService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class OwnerController {
	@Autowired
	OwnerService ownerService;
	
	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	@PutMapping("/updateOwner")
	public Owner updateOwner(@RequestParam int oldId,@RequestBody Owner newowner) {
		newowner.setOwnerId(oldId);
		ownerService.saveOwner(newowner);
		return newowner;
	}
	
	@GetMapping("/fetchOwnerById")
	public ResponseStructure<Owner> fetchOwner(@RequestParam int id) {
		return ownerService.fetchOwner(id);
	}
	
	@GetMapping("/fetchAllOwners")
	public ResponseStructureList<Owner> fetchAllOwners(){
		return ownerService.fetchAll();
	}
	
	@DeleteMapping("/deleteOwner")
	public ResponseStructure<Owner> deleteOwner(@RequestParam int id) {
	ResponseStructure<Owner> owner = ownerService.fetchOwner(id);
	ownerService.deleteOwner(id);
	return owner;
	}
	
	@PutMapping("/addExistingBankToExistingOwner")
	public Owner addExistingBankToExistingOwner(int bankId,int ownerId) {
		return ownerService.addExistingBankToExistingOwner(bankId, ownerId);
		
	}
}
