package com.wvwv.ch21ex01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wvwv.ch21ex01.command.BCommand;

@Controller
public class BController {

	@Autowired
	private BCommand command;
	
	@RequestMapping("/list")
	public String list() {
		return "list";
	}
	
}
