package com.qsp.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.service.CardService;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@RestController
public class CardController {
	@Autowired
	CardService cardService;
	
	@PostMapping("/saveCard")
	public ResponseStructure<Card> saveCard(@RequestBody Card card) {
		return cardService.saveCard(card);
	}
	
	@PutMapping("/updateCard")
	public Card updateCard(@RequestParam int oldId,@RequestBody Card newcard) {
		newcard.setCardId(oldId);
		cardService.saveCard(newcard);
		return newcard;
	}
	
	@GetMapping("/fetchCardById")
	public ResponseStructure<Card> fetchCard(@RequestParam int id) {
		return cardService.fetchCard(id);
	}
	
	@GetMapping("fetchAllCards")
	public ResponseStructureList<Card> fetchAllCards(){
		return cardService.fetchAllCards();
	}
	
	@DeleteMapping("/deleteCard")
	public ResponseStructure<Card> deleteCard(@RequestParam int id) {
	ResponseStructure<Card> card = cardService.fetchCard(id);
	cardService.deleteCard(id);
	return card;
	}
}
