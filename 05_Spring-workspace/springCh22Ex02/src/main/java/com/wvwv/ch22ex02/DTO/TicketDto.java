package com.wvwv.ch22ex02.DTO;

public class TicketDto {
	private String consumerId;
	private int amount;
	
	public TicketDto() {}
	
	public TicketDto(String consumerId, int amount) {
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
