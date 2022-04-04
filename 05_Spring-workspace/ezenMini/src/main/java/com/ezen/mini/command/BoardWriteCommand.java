package com.ezen.mini.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.util.Constant;

public class BoardWriteCommand implements MiniCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		
		MiniDao mdao = Constant.mdao;
		
		String bName = request.getParameter("bName");
		
		System.out.println(bName);
		
		mdao.write(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"));

	}

}
