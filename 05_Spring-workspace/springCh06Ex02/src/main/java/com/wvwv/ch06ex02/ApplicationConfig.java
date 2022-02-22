package com.wvwv.ch06ex02;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//xml�� bean ���� context�� �����ϴ� Ŭ����
@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		// return type : bean class name / method name : bean id
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		
		Student student = new Student("ȫ�浿", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		// return type : bean class name / method name : bean id
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("�ٳѱ�");
		hobbys.add("�������");
		
		Student student = new Student("ȫ����", 10, hobbys);
		student.setHeight(126);
		student.setWeight(21);
		
		return student;
	}
}
