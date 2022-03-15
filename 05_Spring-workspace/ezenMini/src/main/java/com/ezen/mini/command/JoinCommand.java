package com.ezen.mini.command;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.ezen.mini.HomeController;
import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.dto.JoinDto;
import com.ezen.mini.util.Constant;

public class JoinCommand implements MiniCommand {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Override
	public void execute(HttpServletRequest request, Model model) {
		logger.info("execute() in >>>>");
		
		BCryptPasswordEncoder passwordEncoder = Constant.passwordEncoder;
		
		String bId = request.getParameter("pid");
		String bPw = request.getParameter("ppw");
		String bAddress = request.getParameter("paddress");
		String bHobby = request.getParameter("phobby");
		String bProfile = request.getParameter("pprofile");
		
		String bPw_org = bPw;
		bPw = passwordEncoder.encode(bPw_org);
		
		JoinDto dto = new JoinDto(bId, bPw, bAddress, bHobby, bProfile);
		MiniDao mdao = Constant.mdao;
		String result = mdao.join(dto);
		
		request.setAttribute("result", result);
		logger.info("execute() out >>>>");
	}

}
