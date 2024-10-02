package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Bank;
import com.qsp.Banking_Management_System.dto.Owner;
import com.qsp.Banking_Management_System.repo.OwnerRepo;



@Repository
public class OwnerDao {
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	BankDao bankDao;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner updateOwner(int oldId,Owner newowner) {
		newowner.setOwnerId(oldId);
		ownerRepo.save(newowner);
		return newowner;
	}
	
	public Owner fetchOwner(int id) {
		 Optional<Owner>  owner = ownerRepo.findById(id);
		if(owner.isPresent()) {
			return owner.get();
		} else {
			return null;
		}
	}
	
	public List<Owner> fetchAllOwners(){
		return ownerRepo.findAll();
	}
	
	public Owner deleteOwner(int id) {
	Owner owner = ownerRepo.findById(id).get();
	ownerRepo.delete(owner);
	return owner;
	}
	
	public Owner addExistingBankToExistingOwner(int bankId,int ownerId) {
		Bank bank=bankDao.fetchBank(bankId);
		Owner owner=fetchOwner(ownerId);
		owner.setBank(bank);
		return ownerRepo.save(owner);
	}
}
