package com.ezen.mini.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.dto.BoardDto;
import com.ezen.mini.util.Constant;

public class BoardPageCommand implements MiniCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		MiniDao mdao = Constant.mdao;
		
		String pageNo = request.getParameter("pageNo");
		
		ArrayList<BoardDto> dtos = mdao.pageList(pageNo);
		model.addAttribute("listContent", dtos);
	}

}
