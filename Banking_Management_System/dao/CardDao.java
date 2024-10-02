package com.qsp.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.repo.CardRepo;


@Repository
public class CardDao {
	@Autowired
	CardRepo cardRepo;
	
	public Card saveCard(Card card) {
		return cardRepo.save(card);
	}
	
	public Card updateCard(int oldId,Card newcard) {
		newcard.setCardId(oldId);
		cardRepo.save(newcard);
		return newcard;
	}
	
	public Card fetchCard(int id) {
		 Optional<Card>  card = cardRepo.findById(id);
			if(card.isPresent()) {
				return card.get();
			} else {
				return null;
			}
	}
	
	public List<Card> fetchAllCards(){
		return cardRepo.findAll();
	}
	
	public Card deleteCard(int id) {
	Card card = cardRepo.findById(id).get();
	cardRepo.delete(card);
	return card;
	}
}
