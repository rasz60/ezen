package com.wvwv.ch23ex01;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wvwv.ch23ex01.dao.TicketDao;
import com.wvwv.ch23ex01.dto.TicketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private TicketDao dao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "buyTicket";
	}
	
	@RequestMapping("/buyTicketCard")
	public String buyTicketCard(TicketDto dto, Model model) {
		System.out.println("buyTicketCard()");
		
		dao.buyTicekt(dto);
		
		model.addAttribute("ticketInfo", dto);
		return "buyTicketEnd";
	}
	
}
