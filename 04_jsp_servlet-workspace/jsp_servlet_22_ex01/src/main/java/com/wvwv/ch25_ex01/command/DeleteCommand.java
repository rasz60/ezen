package com.wvwv.ch25_ex01.command;

public class DeleteCommand implements MyCommand {

	@Override
	public void execute() {
		System.out.println("DeleteCommand���� delete ��û ó��.");
	}
	
}
