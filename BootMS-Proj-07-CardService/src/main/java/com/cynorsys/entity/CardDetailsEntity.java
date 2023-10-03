package com.cynorsys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "CARD_DETAILS")
public class CardDetailsEntity {
	
	@Id
	@Column(name="CARD_NO")
	public long cardNo;
	
	@Column(name="CARD_HOLDER_NAME")
	public String cardHolderName;

	@Column(name="BANK_NAME")
	public String bankName;

	@Column(name="CARD_TYPE")
	public String cardType;

	@Column(name="VALID")
	public int valid;
}
