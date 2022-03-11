package com.wvwv.sslex01.memberCommand;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MemberCommand {
	
	public void execute(HttpServletRequest request, Model model);
	
}
