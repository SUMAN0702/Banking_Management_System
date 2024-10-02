package com.qsp.Banking_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_Management_System.dao.CardDao;
import com.qsp.Banking_Management_System.dto.Card;
import com.qsp.Banking_Management_System.exception.CardIdNotFound;
import com.qsp.Banking_Management_System.util.ResponseStructure;
import com.qsp.Banking_Management_System.util.ResponseStructureList;

@Service
public class CardService {
	@Autowired
	CardDao cardDao;

	@Autowired
	ResponseStructure<Card> responseStructure;

	@Autowired
	ResponseStructureList<Card> responseStructureList;

	public ResponseStructure<Card> saveCard(Card card) {
		responseStructure.setMessage("SUCESSFULLY CARD INSERTED IN DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(cardDao.saveCard(card));
		return responseStructure;
	}

	public ResponseStructure<Card> updateCard(int oldId, Card newcard) {
		Card card = cardDao.fetchCard(oldId);
		if (card != null) {
			responseStructure.setMessage("SUCESSFULLY CARD UPDADTE IN DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(cardDao.updateCard(oldId, newcard));
			return responseStructure;
		} else {
			throw new CardIdNotFound();
		}
	}

	public ResponseStructure<Card> fetchCard(int id) {
		Card card = cardDao.fetchCard(id);
		if (card != null) {
			responseStructure.setMessage("SUCESSFULLY CARD FETCHED FROM DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(cardDao.fetchCard(id));
			return responseStructure;
		} else {
			throw new CardIdNotFound();
		}
	}

	public ResponseStructureList<Card> fetchAllCards() {
		responseStructureList.setMessage("SUCESSFULLY CARDS FETCHED FROM DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(cardDao.fetchAllCards());
		return responseStructureList;
	}

	public ResponseStructure<Card> deleteCard(int id) {
		Card card = cardDao.fetchCard(id);
		if (card != null) {

			responseStructure.setMessage("SUCESSFULLY CARD DELETED FROM DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(cardDao.deleteCard(id));
			return responseStructure;
		} else {
			throw new CardIdNotFound();
		}
	}
}
