package com.wvwv.jspMVC.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	// command 클래스들이 공통으로 구현할 메서드
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
