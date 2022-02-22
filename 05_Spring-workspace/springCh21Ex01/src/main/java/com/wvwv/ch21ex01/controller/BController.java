package com.wvwv.ch21ex01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wvwv.ch21ex01.DTO.WriteFormDTO;
import com.wvwv.ch21ex01.command.BCommand;
import com.wvwv.ch21ex01.command.BListCommand;
import com.wvwv.ch21ex01.command.BWriteCommand;
import com.wvwv.ch21ex01.util.Constant;

@Controller
public class BController {

	private BCommand command;
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = template;
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(Model model) {
		return "writeForm";
	}
/*	
 	//1. request로 파라미터 넘기기	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()------------------");
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
*/
	//2. 
	@RequestMapping("/write")
	public String write(WriteFormDTO wfdto, Model model) {
		System.out.println("write()------------------");
		model.addAttribute("wfdto", wfdto);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}
