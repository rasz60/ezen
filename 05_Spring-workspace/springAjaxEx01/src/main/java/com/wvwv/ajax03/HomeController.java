package com.wvwv.ajax03;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wvwv.ajax03.dto.DTO;

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
		
		return "springAjax1";
	}
	
	@RequestMapping(value = "/formAct", produces="application/text; charset=UTF-8")
	@ResponseBody
	public String formAct(DTO dto) {
		logger.info("init : " + dto.getName() + "and " + dto.getAge() );
		
		return dto.getName() + " and " + dto.getAge();
	}
	
	@RequestMapping(value = "/requestObject", produces="application/text; charset=UTF-8")
	@ResponseBody
	public String requestObject(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		return name + " and " + age;
	}

}
