package com.wvwv.sslex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/join_view")
	public String join_view() {
		return "join_view";
	}
}
