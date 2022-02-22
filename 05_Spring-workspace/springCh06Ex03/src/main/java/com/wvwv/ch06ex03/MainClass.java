package com.wvwv.ch06ex03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//java���� annotation�� �̿��Ͽ� ������ student1
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1);
		
		//xml�� �̿��Ͽ� ������ student2
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student2);
		
		ctx.close();
	}

}
