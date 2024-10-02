package com.qsp.Banking_Management_System.dto;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Card {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;
	private String cardType;
	private long cardNumber;
	private Date cardExpiry;
	private int cardCVV;
	private double cardLimit;
	
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public int getCardCVV() {
		return cardCVV;
	}
	public void setCardCVV(int cardCVV) {
		this.cardCVV = cardCVV;
	}
	public double getCardLimit() {
		return cardLimit;
	}
	public void setCardLimit(double cardLimit) {
		this.cardLimit = cardLimit;
	}
	
}
