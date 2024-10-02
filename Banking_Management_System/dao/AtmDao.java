package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.repo.AtmRepo;

@Repository
public class AtmDao {
	@Autowired
	AtmRepo atmRepo;
	
	public Atm saveAtm(Atm atm) {
		return atmRepo.save(atm);
	}
	
	public Atm updateAtm(int oldId,Atm newatm) {
		newatm.setAtmId(oldId);
		atmRepo.save(newatm);
		return newatm;
	}
	
	public Atm fetchAtm(int id) {
		 Optional<Atm>  atm = atmRepo.findById(id);
			if(atm.isPresent()) {
				return atm.get();
			} else {
				return null;
			}
	}
	
	public List<Atm> fetchAllAtms(){
		return atmRepo.findAll();
	}
	
	public Atm deleteAtm(int id) {
	Atm atm = atmRepo.findById(id).get();
	atmRepo.delete(atm);
	return atm;
	}

}
