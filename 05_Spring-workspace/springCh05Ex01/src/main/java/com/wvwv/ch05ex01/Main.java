package com.wvwv.ch05ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		StudentInfo sInfo = ctx.getBean("studentInfo", StudentInfo.class);
		sInfo.getStudentInfo();
		
		// applicationCTX.xml에서 초기 값으로 지정된 객체(value)는 setXXX 메서드로 변경할 수 있다.
		Student student2 = ctx.getBean("student2", Student.class);
		sInfo.setStudent(student2);
		sInfo.getStudentInfo();
	}

}
