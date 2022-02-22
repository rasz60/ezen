package com.wvwv.ch06ex03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//java에서 annotation을 이용하여 생성한 student1
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1);
		
		//xml을 이용하여 생성한 student2
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student2);
		
		ctx.close();
	}

}
