package com.wvwv.ch21ex01.command;

import org.springframework.ui.Model;

import com.wvwv.ch21ex01.DAO.BDAO;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BDAO bDao = new BDAO();
		model.addAttribute("list", bDao.list());
	}
	
	
}
