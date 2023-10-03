package com.cynorsys.model;

import lombok.Data;

@Data
public class CardDetails {

	public String cardHolderName;
	
	public String bankName;
	
	public String cardType;
	
	public long cardNo;
	
	public int valid;
}
