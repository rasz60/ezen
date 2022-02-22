package com.wvwv.ch15ex01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wvwv.ch15ex01.HomeController;
import com.wvwv.ch15ex01.DTO.Student;
import com.wvwv.ch15ex01.util.StudentValidator;

@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/studentForm")
	public String studnetForm() {
		logger.info("studentForm()");
		
		return "formPage";
	}
	
	@PostMapping("/create")						//에러 내용을 전달하는 Errors 인터페이스를 상속
	public String studentCreate(Student student, BindingResult result) {
		logger.info("studentCreate()");
		
		String page = "createDonePage";
		StudentValidator validator = new StudentValidator();
		
		validator.validate(student, result);
		if (result.hasErrors()) {
			page = "formPage";
		}
		
		return page;
	}
}
