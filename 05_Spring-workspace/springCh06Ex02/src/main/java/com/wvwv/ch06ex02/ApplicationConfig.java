package com.wvwv.ch06ex02;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//xml에 bean 관련 context를 설정하는 클래스
@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		// return type : bean class name / method name : bean id
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		// return type : bean class name / method name : bean id
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("줄넘기");
		hobbys.add("공기놀이");
		
		Student student = new Student("홍길자", 10, hobbys);
		student.setHeight(126);
		student.setWeight(21);
		
		return student;
	}
}
