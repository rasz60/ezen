package com.wvwv.ch22ex01.DTO;

import org.springframework.stereotype.Component;

public class TicketDto {
	private String consumerId;
	private int amount;
	
	public TicketDto() {
		super();
	}
	
	public TicketDto(String consumerId, int amount) {
		super();
		this.consumerId = consumerId;
		this.amount = amount;
	}
	
	public String getConsumerId() {
		return consumerId;
	}
	
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
