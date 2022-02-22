package com.wvwv.ch22ex02;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wvwv.ch22ex02.DAO.TicketDao;
import com.wvwv.ch22ex02.DTO.TicketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private TicketDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home!-----------------------------------------------------------");
		
		return "buyTicket";
	}
	
	@RequestMapping("/buyTicketCard")
	public String buyTicketCard(TicketDto ticketDto, Model model) {
		logger.info("buyTicketCard---------------------");
		
		dao.buyTicket(ticketDto);
		model.addAttribute("ticketInfo", ticketDto);
		return "buyTicketEnd";
	}
}
