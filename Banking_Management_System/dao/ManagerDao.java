package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Manager;
import com.qsp.Banking_Management_System.repo.ManagerRepo;


@Repository
public class ManagerDao {
	
		@Autowired
		ManagerRepo managerRepo;
		
		public Manager saveManager(Manager manager) {
			return managerRepo.save(manager);
		}
		
		public Manager updateManager(int oldId,Manager newmanager) {
			newmanager.setManagerId(oldId);
			managerRepo.save(newmanager);
			return newmanager;
		}
		
		public Manager fetchManager(int id) {
			 Optional<Manager>  manager = managerRepo.findById(id);
				if(manager.isPresent()) {
					return manager.get();
				} else {
					return null;
				}
		}
		
		public List<Manager> fetchAllManagers(){
			return managerRepo.findAll();
		}
		
		public Manager deleteManager(int id) {
		Manager manager = managerRepo.findById(id).get();
		managerRepo.delete(manager);
		return manager;
		}
	}
