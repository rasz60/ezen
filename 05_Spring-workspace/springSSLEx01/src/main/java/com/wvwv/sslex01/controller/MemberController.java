package com.wvwv.sslex01.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wvwv.sslex01.dao.MemberDao;
import com.wvwv.sslex01.memberCommand.JoinCommand;
import com.wvwv.sslex01.memberCommand.MemberCommand;
import com.wvwv.sslex01.util.Constant;

@Controller
public class MemberController {
	
	private MemberCommand mcom;
	private MemberDao mdao;
	BCryptPasswordEncoder passwordEncoder;

	
	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		Constant.passwordEncoder = passwordEncoder;
	}
	
	@Autowired
	public void setMemberDao(MemberDao mdao) {
		this.mdao = mdao;
		Constant.mdao = mdao;
	}
	
	
	@RequestMapping("/join_view")
	public String join_view() {
		return "join_view";
	}
	
	
	@RequestMapping("/login_view")
	public String login_view() {
		return "login_view";
	}
	
	@RequestMapping(value="/join", produces="application/text; charset=UTF-8")
	@ResponseBody
	public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("join");
		
		mcom = new JoinCommand();
		mcom.execute(request, model);
		String result = (String)request.getAttribute("result");
		System.out.println(result);
		
		if(result.equals("success")) {
			return "join_success";
		} else {		
			return "join_failed";
		}
	}
	
	@RequestMapping(value="/processLogin", method= RequestMethod.GET)
	public ModelAndView processingLogin(@RequestParam(value="log", required = false) String log,
										@RequestParam(value="error", required = false) String error,
										@RequestParam(value="logout", required = false) String logout, HttpSession session) {
		
		System.out.println(log + "/" + logout + "/" + error);
		
		
		ModelAndView model = new ModelAndView();
		
		if( log != null && log != "" ) {
			model.addObject("log", "before login!");
		} 
		
		if( logout != null && logout != "" ) {
			model.addObject("logout", "You've been logged out successfully.");
		} 
		
		if( error != null && error != "" ) {
			model.addObject("error", "Invalid username or password!");
		} 	
		
		model.setViewName("login_view");
		return model;
	}
	
	@RequestMapping("/main")
	public String main(Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
}
