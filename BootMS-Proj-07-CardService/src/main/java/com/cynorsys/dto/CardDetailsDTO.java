package com.cynorsys.dto;

import lombok.Data;

@Data
public class CardDetailsDTO {

	public String cardHolderName;

	public String bankName;

	public String cardType;

	public long cardNo;

	public int valid;
}
