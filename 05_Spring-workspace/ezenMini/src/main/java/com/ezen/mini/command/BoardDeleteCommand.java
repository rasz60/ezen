package com.ezen.mini.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.util.Constant;

public class BoardDeleteCommand implements MiniCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		MiniDao mdao = Constant.mdao;
		
		String bId = request.getParameter("bId");
		mdao.delete(bId);
	}

}
