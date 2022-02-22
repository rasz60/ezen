package com.wvwv.ch06ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String configLocation1 = "classpath:applicationCTX1.xml";
		String configLocation2 = "classpath:applicationCTX2.xml";
		
		// GenericXmlApplicationContext�� �����ڴ� ���� ���ڸ� �����Ƿ�, ���� �� xml�� �� �� �ִ�.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		
		Student student2 = studentInfo.getStudent();
		System.out.println(student2.getName());
		System.out.println(student2.getHobbys());
		
		if( student1.equals(student2) ) {
			System.out.println("student1, student2�� ���� �л��Դϴ�.");
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3.getName());
		
		if( student1.equals(student3) ) {
			System.out.println("student1, student3�� ���� �л��Դϴ�.");			
		} else {
			System.out.println("student1, student3�� �ٸ� �л��Դϴ�.");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		ctx.close();
	}

}
