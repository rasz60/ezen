package com.ezen.mini.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.mini.HomeController;
import com.ezen.mini.command.JoinCommand;
import com.ezen.mini.command.MiniCommand;
import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.util.Constant;

@Controller
public class EzenMiniController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private MiniDao mdao;
	private BCryptPasswordEncoder passwordEncoder;
	private MiniCommand mcom;
	
	@Autowired
	public void setMiniDao(MiniDao mdao) {
		this.mdao = mdao;		
		Constant.mdao = this.mdao;
	}
	
	@Autowired
	public void setpasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;		
		Constant.passwordEncoder = this.passwordEncoder;
	}

	@RequestMapping("join_view")
	public String join_view() {
		logger.info("join_view >>>>");
		return "join_view";
	}
	
	@RequestMapping(value="/join", produces="application/text; charset=UTF-8")
	@ResponseBody
	public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("join in >>>>");
		mcom = new JoinCommand();
		mcom.execute(request, model);
		String result = (String)request.getAttribute("result");
		
		logger.info(result);
		
		if( result.equals("success") ) {
			logger.info("join out - success >>>>");
			return "join-success";
		} else {
			logger.info("join out - failed >>>>");
			return "join-failed";
		}
	}
	
	@RequestMapping("login_view")
	public String login_view(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		logger.info("login_view >>>>");
		return "login_view";
	}
	
	
}
