package com.wvwv.ch25_ex01.command;

public class InsertCommand implements MyCommand {

	@Override
	public void execute() {
		System.out.println("InsertCommand에서 insert 요청 처리.");
	}
	
}
