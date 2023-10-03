package com.cynorsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cynorsys.entity.CardDetailsEntity;

import jakarta.transaction.Transactional;
@Transactional
public interface ICardDetailsRepo extends JpaRepository<CardDetailsEntity, Integer> {

//	@Query("SELECT * FROM card_details WHERE name = :cardHolderName")
	// @Query("SELECT c FROM CardDetailsEntity c WHERE c.name = :cardHolderName")
	public CardDetailsEntity findByCardHolderName(String cardHolderName);

//@Query("DELETE FROM card_details WHERE name = :cardHolderName")
	// @Query("DELETE FROM CardDetailsEntity c WHERE c.name = :cardHolderName")
//@Modifying   

 
	public String deleteByCardHolderName(String cardHolderName);

}
