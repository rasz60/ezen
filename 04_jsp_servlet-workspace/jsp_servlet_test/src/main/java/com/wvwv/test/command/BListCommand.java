package com.wvwv.test.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wvwv.test.DAO.BDAO;
import com.wvwv.test.DTO.BDTO;

public class BListCommand implements BCommand {

	BDAO bDao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		bDao = new BDAO();
		
		ArrayList<BDTO> bDtos = bDao.getBList();
		
		request.setAttribute("boardList", bDtos);
	}

}
