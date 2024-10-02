package com.qsp.Banking_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atm {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int atmId;
	private String atmType;
	private String atmCapacity;
	public int getAtmId() {
		return atmId;
	}
	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}
	public String getAtmType() {
		return atmType;
	}
	public void setAtmType(String atmType) {
		this.atmType = atmType;
	}
	public String getAtmCapacity() {
		return atmCapacity;
	}
	public void setAtmCapacity(String atmCapacity) {
		this.atmCapacity = atmCapacity;
	}
}
