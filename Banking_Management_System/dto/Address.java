package com.qsp.Banking_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private int addressPlotNumber;
	private String addressState;
	private String addressCity;
	private long addressPincode;
	private String addressLandmark;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getAddressPlotNumber() {
		return addressPlotNumber;
	}
	public void setAddressPlotNumber(int addressPlotNumber) {
		this.addressPlotNumber = addressPlotNumber;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public long getAddressPincode() {
		return addressPincode;
	}
	public void setAddressPincode(long addressPincode) {
		this.addressPincode = addressPincode;
	}
	public String getAddressLandmark() {
		return addressLandmark;
	}
	public void setAddressLandmark(String addressLandmark) {
		this.addressLandmark = addressLandmark;
	}
	
}
