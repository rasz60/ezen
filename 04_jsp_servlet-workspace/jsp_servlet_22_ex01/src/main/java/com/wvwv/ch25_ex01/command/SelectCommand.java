package com.wvwv.ch25_ex01.command;

public class SelectCommand implements MyCommand {

	@Override
	public void execute() {
		System.out.println("SelectCommand���� Select ��û ó��.");
	}
	
}