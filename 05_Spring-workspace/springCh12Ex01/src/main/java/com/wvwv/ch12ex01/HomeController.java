package com.wvwv.ch12ex01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
//해당 클래스를 Controller 클래스로 설정
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 요청 경로 처리 : value="요청경로" / method="RequestMethod.GET or POST"
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		// servlet-context에 지정한 ViewResolver bean 내용에 따라 /WEB-INf/views/~~~.jsp ~~~부분의 값이 됨
	}
	
	// /board/view로 요청이 오면 board.jsp를 실행
	@RequestMapping(value="/board/view")
	public String board() {
		return "board/view";
	}
	
	// /board/content로 요청이 오면 model
	@RequestMapping(value="/board/content")
	public String content(Model model) {
		// model은 데이터를 처리하는 클래스 객체
		// addAttribute("attrName", Object) : mapping된 jsp 파일에서 쓸 수 있는 속성 값 추가
		model.addAttribute("id", 30);
		return "board/content";
	}
	
	@RequestMapping(value="/board/reply")
	public ModelAndView reply() {
		//ModelAndView는 model과 view를 동시에 처리하는 클래스
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30);
		mv.setViewName("/board/reply");
		return mv;
	}
}
