package com.cynorsys.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynorsys.dao.ICardDetailsRepo;
import com.cynorsys.dto.CardDetailsDTO;
import com.cynorsys.entity.CardDetailsEntity;
import com.cynorsys.model.CardDetails;

@Service
public class CardDetailsServiceImpl implements ICardDetailsService {

	
	@Autowired
	private ICardDetailsRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<CardDetailsDTO> getAllDetails() {
		TypeToken<List<CardDetailsDTO>> typeToken=new TypeToken<List<CardDetailsDTO>>() {};
		List<CardDetailsEntity> entity=repo.findAll();
		List<CardDetailsDTO> dto=this.mapper.map(entity, typeToken.getType());
		return dto;
	}

	@Override
	public CardDetailsDTO getCardByName(String cardHolderName) {
		CardDetailsDTO dto= new CardDetailsDTO();
		CardDetailsEntity entity=repo.findByCardHolderName(cardHolderName);
	    if(entity!=null) {
	    	dto=this.mapper.map(entity, CardDetailsDTO.class);
	    	return dto;
	    }
		return null;
	}

	@Override
	public CardDetailsEntity updateCardDetails(CardDetails cardDetails) {
		CardDetailsEntity status=null;
		CardDetailsEntity entity=repo.findByCardHolderName(cardDetails.getCardHolderName());
		if(entity!=null) {
			entity.setCardNo(cardDetails.getCardNo());
			entity.setCardType(cardDetails.getCardType());
			status=repo.save(entity);
			return status;
		}
		return null;
	}

	@Override
	public CardDetailsEntity saveCardDetails(CardDetails cardDetails) {
		CardDetailsEntity status=null;
		CardDetailsEntity entity=this.mapper.map(cardDetails, CardDetailsEntity.class);
		if(entity!=null) {
			status=repo.save(entity);
			return status;
		}
		return null;
	}

	@Override
	public String deleteCardDetails(String cardHolderName) {
	   String response=null;
	   if(cardHolderName!=null) {
		   response=repo.deleteByCardHolderName(cardHolderName);
		   return response;
	   }
		return null;
	}
	
}
