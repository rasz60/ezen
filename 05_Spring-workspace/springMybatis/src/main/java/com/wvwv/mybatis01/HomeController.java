package com.wvwv.mybatis01;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wvwv.mybatis01.dao.ContentDao;
import com.wvwv.mybatis01.dao.UserTransaction;
import com.wvwv.mybatis01.dto.ContentDTO;
import com.wvwv.mybatis01.dto.TicketDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ContentDao dao;
	@Autowired	
	private UserTransaction udao;
	
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
		
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		ArrayList<ContentDTO> list = dao.listDao();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		dao.deleteDao(request.getParameter("mId"));
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		ArrayList<ContentDTO> list = dao.viewDao(request.getParameter("mId"));
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket(HttpServletRequest request, Model model) {
		return "buyTicket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket(TicketDTO ticketDto, Model model) {
		udao.transactionEx(dao, ticketDto);
		model.addAttribute("ticektInfo", ticketDto);
		return "buyTicketEnd";
	}
	
}
