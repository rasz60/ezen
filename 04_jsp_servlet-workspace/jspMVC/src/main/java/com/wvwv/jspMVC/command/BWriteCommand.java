package com.wvwv.jspMVC.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wvwv.jspMVC.DAO.BDao;

public class BWriteCommand implements BCommand {

	@Override
	// Request from 'writeForm.do'
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao bDao = new BDao();
		bDao.write(bName, bTitle, bContent);
	}

}
