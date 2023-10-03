package com.cynorsys.service;

import java.util.List;

import com.cynorsys.dto.CardDetailsDTO;
import com.cynorsys.entity.CardDetailsEntity;
import com.cynorsys.model.CardDetails;

public interface ICardDetailsService {

	public List<CardDetailsDTO> getAllDetails();
	
	public CardDetailsDTO getCardByName(String cardHolderName);
	
	public CardDetailsEntity updateCardDetails(CardDetails cardDetails);
	
	public CardDetailsEntity saveCardDetails(CardDetails cardDetails);
	
	public String deleteCardDetails(String cardHolderName);
}
