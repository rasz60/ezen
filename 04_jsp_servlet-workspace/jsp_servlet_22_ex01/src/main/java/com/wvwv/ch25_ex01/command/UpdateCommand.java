package com.wvwv.ch25_ex01.command;

public class UpdateCommand implements MyCommand {

	@Override
	public void execute() {
		System.out.println("UpdateCommand���� update ��û ó��.");
	}

}