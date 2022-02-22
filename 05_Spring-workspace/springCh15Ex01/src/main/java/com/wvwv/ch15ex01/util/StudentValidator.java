package com.wvwv.ch15ex01.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wvwv.ch15ex01.DTO.Student;

// form value validation class
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	// 데이터에 대한 검증 처리 구현
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validation()");
		
		Student student = (Student)target;
/*		
		if ( student.getName() == null || student.getName().trim().isEmpty() ) {
			System.out.println("studentName is null or empty.");
			//에러 내용을 저장하는 객체
			errors.rejectValue("name", "name trouble");
		} else if ( student.getId() == 0 ) {
			System.out.println("studentId is null.");
			errors.rejectValue("id", "trouble");
		}
*/
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		
		if ( student.getId() == 0 ) {
			System.out.println("studentId is null.");
			errors.rejectValue("id", "trouble");
		}
	}

}
