package com.wvwv.ch21ex01.command;

import org.springframework.ui.Model;

public interface BCommand {
	// model을 통해서 데이터를 전달
	public void execute(Model model);

}
