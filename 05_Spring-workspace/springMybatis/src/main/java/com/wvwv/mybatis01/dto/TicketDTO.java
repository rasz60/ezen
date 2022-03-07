package com.wvwv.mybatis01.dto;

public class TicketDTO {
	private String consumerId;
	private String amount;
	
	public TicketDTO() {
		super();
	}
	
	public TicketDTO(String consumerId, String amount) {
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
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	   
}
