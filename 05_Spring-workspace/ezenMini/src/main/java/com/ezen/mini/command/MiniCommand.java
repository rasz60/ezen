package com.ezen.mini.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MiniCommand {
	
	void execute(HttpServletRequest request, Model model);
	
}
