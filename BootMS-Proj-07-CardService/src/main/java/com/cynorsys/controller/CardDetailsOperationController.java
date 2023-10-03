package com.cynorsys.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cynorsys.dto.CardDetailsDTO;
import com.cynorsys.entity.CardDetailsEntity;
import com.cynorsys.model.CardDetails;
import com.cynorsys.service.ICardDetailsService;

@RestController
@RequestMapping("/card-service")
public class CardDetailsOperationController {

	private static final Logger log=LoggerFactory.getLogger(CardDetailsOperationController.class);
	@Autowired
	private ICardDetailsService service;

	@GetMapping("/all-cards")
	public ResponseEntity<?> getAllDetails() {
		List<CardDetailsDTO> dto = service.getAllDetails();
		return new ResponseEntity<>(dto, HttpStatus.OK);
		/*if (dto.equals(1)) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Data Not Found some Technical issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
	}
	
		@GetMapping("/get-card")
		public ResponseEntity<?> getCardByName(@RequestParam String cardHolderName){
			CardDetailsDTO dto=service.getCardByName(cardHolderName);
			if (dto.equals(1)) {
				return new ResponseEntity<>(dto, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Data Not Found some Technical issue", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/update-card")
		public ResponseEntity<?> updateCardDetails(@RequestBody CardDetails cardDetails){
			CardDetailsEntity entity=service.updateCardDetails(cardDetails);
			if(entity!=null) {
				return new ResponseEntity<>("Record updated successfully ", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Input MissMatch Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
	@PostMapping("/save-card")
	public ResponseEntity<?> saveCardDetails(@RequestBody CardDetails cardDetails) {
		CardDetailsEntity entity=service.saveCardDetails(cardDetails);
		if(entity!=null) {
			return new ResponseEntity<>("Record inserted successfully ", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Data already Exixt, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@DeleteMapping("/delete-card")
	public ResponseEntity<String> deleteCardDetails(@RequestParam String cardHolderName){
		String response=service.deleteCardDetails(cardHolderName);
		return new ResponseEntity<>("Record delete successfully ",HttpStatus.OK);
		/*if(response.equals(1)) {
			return new ResponseEntity<>("Record delete successfully ",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Record Not delete successfully, Please Try Again",HttpStatus.OK);
		}*/
	}
}
