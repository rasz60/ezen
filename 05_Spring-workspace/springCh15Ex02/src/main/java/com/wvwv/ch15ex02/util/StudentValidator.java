package com.wvwv.ch15ex02.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wvwv.ch15ex02.DTO.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("supports()");
		return Student.class.isAssignableFrom(clazz);
	}

	// 데이터에 대한 검증 처리 구현
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validation()");
		
		Student student = (Student)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
	}

}
