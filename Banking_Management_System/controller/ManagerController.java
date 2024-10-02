package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_Management_System.dto.Manager;
import com.qsp.Banking_Management_System.service.ManagerService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/saveManager")
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}
	
	@PutMapping("/updateManager")
	public Manager updateManager(@RequestParam int oldId,@RequestBody Manager newmanager) {
		newmanager.setManagerId(oldId);
		managerService.saveManager(newmanager);
		return newmanager;
	}
	
	@GetMapping("/fetchManagerById")
	public ResponseStructure<Manager> fetchManager(@RequestParam int id) {
		return managerService.fetchManager(id);
	}
	
	@GetMapping("/fetchAllManagers")
	public ResponseStructureList<Manager> fetchAllOwners(){
		return managerService.fetchAllManagers();
	}
	
	@DeleteMapping("/deleteManager")
	public ResponseStructure<Manager> deleteOwner(@RequestParam int id) {
	ResponseStructure<Manager> manager = managerService.fetchManager(id);
	managerService.deleteManager(id);
	return manager;
	}
}
