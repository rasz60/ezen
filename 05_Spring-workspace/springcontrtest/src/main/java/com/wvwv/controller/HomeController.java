package com.wvwv.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
		System.out.println("intoHome()-----------------------------");
		model.addAttribute("name", "김진웅" );
		return "home";
	}

	
	@RequestMapping(value = "/test")
	public String test(Model model) {
		System.out.println("intoTest()-----------------------------");
		model.addAttribute("id", "SIXT");
		return "test";
	}
}
