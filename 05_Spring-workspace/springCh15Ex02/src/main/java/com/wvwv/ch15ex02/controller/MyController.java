package com.wvwv.ch15ex02.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wvwv.ch15ex02.DTO.Student;
import com.wvwv.ch15ex02.util.StudentValidator;

@Controller
public class MyController {

	@RequestMapping("/formPage")
	public String formPage() {
		System.out.println("formPage()");
		return "formPage";
	}
	
	@RequestMapping("/create")
	// hibernate와 validation을 사용할 시 @Valid 어노테이션 사용
	public String create(@Valid Student student, BindingResult result) {
		System.out.println("createDonePage()");
		String page = "createDonePage";
		
		if ( result.hasErrors() ) {
			System.out.println("create failed.");
			page = "formPage";
		} else {
			System.out.println("create Successed.");
		}
		
		System.out.println("go to " + page);
		return page;
	}

	//Validator 처리를 수행할 클래스를 지정
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		System.out.println("initBinder()");
		binder.setValidator(new StudentValidator());
	}
}
