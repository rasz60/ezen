package com.wvwv.jspMVC.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	// command Ŭ�������� �������� ������ �޼���
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
