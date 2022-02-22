package com.wvwv.ch08ex03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// ������̼� Configuration���� ������ context ��ü�� �������� Ŭ����
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		AdminConnection connection = ctx.getBean("adminConfig", AdminConnection.class);
		
		System.out.println(connection);
		ctx.close();
	}

}
