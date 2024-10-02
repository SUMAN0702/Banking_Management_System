package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_Management_System.dto.Atm;
import com.qsp.Banking_Management_System.service.AtmService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class AtmController {
	@Autowired
	AtmService atmService;
	
	@PostMapping("/saveAtm")
	public ResponseStructure<Atm> saveAtm(@RequestBody Atm atm) {
		return atmService.saveAtm(atm);
	}
	
	@PutMapping("/updateAtm")
	public Atm updateAtm(@RequestParam int oldId,@RequestBody Atm newatm) {
		newatm.setAtmId(oldId);
		atmService.saveAtm(newatm);
		return newatm;
	}
	
	@GetMapping("/fetchAtmById")
	public ResponseStructure<Atm> fetchAtm(@RequestParam int id) {
		return atmService.fetchAtm(id);
	}
	
	@GetMapping("/fetchAllAtms")
	public ResponseStructureList<Atm> fetchAllAtms(){
		return atmService.fetchAllAtms();
	}
	
	@DeleteMapping("/deleteAtm")
	public ResponseStructure<Atm> deleteAtm(@RequestParam int id) {
	ResponseStructure<Atm> atm = atmService.fetchAtm(id);
	atmService.deleteAtm(id);
	return atm;
	}
}
