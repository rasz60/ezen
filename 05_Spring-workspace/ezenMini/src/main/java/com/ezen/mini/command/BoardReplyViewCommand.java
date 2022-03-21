package com.ezen.mini.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.dto.BoardDto;
import com.ezen.mini.util.Constant;

public class BoardReplyViewCommand implements MiniCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		MiniDao mdao = Constant.mdao;
		
		String bId = request.getParameter("bId");

		BoardDto dto = mdao.reply_view(bId);
		
		model.addAttribute("reply_view", dto);
	}

}
