package com.wvwv.ch25_ex01.command;

public class UpdateCommand implements MyCommand {

	@Override
	public void execute() {
		System.out.println("UpdateCommand에서 update 요청 처리.");
	}

}
