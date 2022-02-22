package com.wvwv.ch25_ex01.command;

public class DeleteCommand implements MyCommand {

	@Override
	public void execute() {
		System.out.println("DeleteCommand에서 delete 요청 처리.");
	}
	
}
