package com.wvwv.ajax02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "getPost";
	}
	
									   // 생성해서 보낼 데이터 타입
	@RequestMapping(value = "ajaxGet", produces = "application/text; charset=UTF-8")
	@ResponseBody // jsp 파일 경로가 아닌 일반 문자열을 반환
	public String ajaxGet(HttpServletRequest request, HttpServletResponse response) {
		return "get method 성공";
	}
		
	@RequestMapping(value = "ajaxPost", produces = "application/text; charset=UTF-8")
	@ResponseBody // jsp 파일 경로가 아닌 일반 문자열을 반환
	public String ajaxPost(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		String city = request.getParameter("name");		
		String msg = "";
		if ( name.equals("Donald") && city.equals("Donaldburg") ) {
			msg = "post method success.";
		} else {
			msg = "wrong parameters";
		}
		
		return msg;
	}
}
