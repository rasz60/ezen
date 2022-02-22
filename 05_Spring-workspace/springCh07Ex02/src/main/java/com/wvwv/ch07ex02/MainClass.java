package com.wvwv.ch07ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");

		// scope�� singleton���� ������ bean [default type]
		Student student1 = ctx.getBean("student", Student.class);
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("ȫ����");	student2.setAge(100);
		
		// ������ ��ü�� �����Ǿ� �Ӽ� �� ������ �� bean�� ����� ��� ��ü�� ���� ����ȴ�.
		System.out.println(student1);
		System.out.println(student2);
		
		ctx.close();
	}

}
