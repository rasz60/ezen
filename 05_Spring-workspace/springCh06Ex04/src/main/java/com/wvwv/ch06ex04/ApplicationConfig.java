package com.wvwv.ch06ex04;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// �ش� ������ Ŭ������ import ��Ű�� annotation
@ImportResource("classpath:applicationCTX.xml")
@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		
		Student student = new Student("ȫ�浿", 20, hobbys);
		return student;
	}
}
