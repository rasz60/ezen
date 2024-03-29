package com.wvwv.jspMVC.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wvwv.jspMVC.DAO.BDao;
import com.wvwv.jspMVC.DTO.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao bDao = new BDao();
		// SELECT DB SetUp
		List<BDto> list = bDao.list();
		
		// request Attribute set 'list'
		request.setAttribute("boardList", list);
	}

}
