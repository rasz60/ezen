package com.wvwv.ch14ex01.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wvwv.ch14ex01.HomeController;

@Controller
public class RedirectController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest request, Model model) {
		logger.info("intoStudentRedirect()");
		
		String id = request.getParameter("id");
		
		if ( id.equals("abc") ) {
			logger.info("studentConfirm() intoEquals()");

			// "redirect:~~~" : client 페이지를 redirect할 페이지를 지정
			return "redirect:studentOk";
		}
		return "redirect:studentNg";
	}
	
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		model.addAttribute("msg", "Existing students");
		return "studentConfirm";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		model.addAttribute("msg", "Not Existing students");
		return "studentConfirm";
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model) {
		//redirect 시킬 때는 full path를 입력한다.
		return "redirect:http://localhost:8181/ch14ex01/studentURL1.jsp";
	}
}
