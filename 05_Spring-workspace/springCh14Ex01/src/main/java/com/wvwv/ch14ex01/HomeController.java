package com.wvwv.ch14ex01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wvwv.ch14ex01.DTO.StudentInforamtion;

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
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		logger.info("intoHome() : " + formattedDate);
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping("/studentView1")
	public String studentView1(StudentInforamtion studentInforamtion, Model model) {
		logger.info("intoStudentView1()");
		
		model.addAttribute("type", "Object In Parameter");
		return "studentInfo1";
	}
	
	//@modelAttribute(name) 을 사용한 객체는 클래스명이 아닌 지정한 이름으로 전달된다.
	@RequestMapping("/studentView2")
	public String studentView2(@ModelAttribute("sInfo") StudentInforamtion studentInforamtion, Model model) {
		logger.info("intoStudentView2()");
		
		model.addAttribute("type", "Use @ModelAttribute For Object In Parameter");
		return "studentInfo2";
	}
	
	
}
