package com.wvwv.ch23ex01.dto;

public class TicketDto {
	private String consumerId;
	private int amount;

	
	public TicketDto() {
		System.out.println("TicketDto const() logging");
	}


	public TicketDto(String consumerId, int amount) {
		System.out.println("TicketDto useFields const() logging");
		this.consumerId = consumerId;
		this.amount = amount;
	}


	public String getConsumerId() {
		System.out.println("getConsumerId logging");
	
		return consumerId;
	}


	public void setConsumerId(String consumerId) {
		System.out.println("setConsumerId logging");
	
		this.consumerId = consumerId;
	}


	public int getAmount() {
		System.out.println("getAmount logging");
	
		return amount;
	}


	public void setAmount(int amount) {
		System.out.println("setAmount logging");
	
		this.amount = amount;
	}
	
	
}
