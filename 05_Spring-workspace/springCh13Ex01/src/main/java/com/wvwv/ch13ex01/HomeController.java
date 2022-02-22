package com.wvwv.ch13ex01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wvwv.ch13ex01.DTO.MemberDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
		
	// request 객체를 이용하여 url로 넘어온 client의 parameter 가져옴 
	@RequestMapping("/confirmId")
	public String confirmId(HttpServletRequest request, Model model) {
 		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		model.addAttribute("paramType", "HttpServletRequest getParameter() 이용");
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		
		return "confirmId";
	}
	
	//RequestParam으로 자동으로 수집된 파라메터를 가져온다.
	@RequestMapping("/checkId")
	public String confirmId(@RequestParam("id") String id, @RequestParam("pwd") String pwd, Model model) {
		model.addAttribute("paramType", "@RequestParam(name) 이용");
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		
		return "confirmId";
	}
	
	@RequestMapping("/join1")
	public String join1(@RequestParam("name") String name, @RequestParam("id") String id, @RequestParam("pwd") String pwd, @RequestParam("email") String email, Model model) {
		model.addAttribute("type", "object model addAttribute()");
		MemberDTO mDto= new MemberDTO(); 
		mDto.setName(name);
		mDto.setId(id);
		mDto.setPwd(pwd);
		mDto.setEmail(email);
		
		model.addAttribute("member", mDto);
		return "joinInfo";
	}
	
	// 객체를 파라미터에 넣어서 전달하면, 변수로 지정한 이름이 아닌 클래스명(앞글자 소문자로)으로 전달
	@RequestMapping("/join2")
	public String join2(@ModelAttribute("member") MemberDTO member, Model model) {
		model.addAttribute("type", "object in method params");
		System.out.println("join2()");
		return "joinInfo";
	}
	
	@RequestMapping("/student/{studentId}")
	// @PathVarialbe : 브라우저 창에 {value}의 값을 변수로 가져옴
	public String getStudent(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("type", "@PathVariable 사용");
		return "studentInfo";
	}
	
}
