package com.ezen.mini.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.dto.BoardDto;
import com.ezen.mini.util.Constant;

public class BoardContentCommand implements MiniCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		MiniDao mdao = Constant.mdao;
		String bid = request.getParameter("bId");
		
		BoardDto dto = mdao.contentView(bid);
		
		if ( dto != null ) {
			model.addAttribute("content_view", dto);
		}
	}

}
