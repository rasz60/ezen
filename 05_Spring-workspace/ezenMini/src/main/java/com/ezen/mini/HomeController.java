package com.ezen.mini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 기본 url로 접속 혹은 권한이 없는 페이지로 접근시 index.jsp로 이동
	@RequestMapping(value= {"/", "/home"})
	public String home() {
		logger.info("index >>>>> ");
		
		return "index";
	}
	
}
