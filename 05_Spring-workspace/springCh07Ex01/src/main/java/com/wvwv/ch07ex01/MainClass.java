package com.wvwv.ch07ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("������ �����̳��� ���� �ֱ�");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("GenericXmlApplicationContext ��ü�� ������ �����̳� ����");
		
		ctx.load("classpath:applicationCTX.xml");
		ctx.refresh();
		// bean ������ �ʱ�ȭ �Ϸ�� �� �ش� Ŭ������ afterPropertiesSet() ����
		System.out.println("ctx.load('classpath:~~') : ���� / ctx.refresh() : �ʱ�ȭ");		
		
		Student student1 = ctx.getBean("student", Student.class);
		OtherStudent student2 = ctx.getBean("otherStudent", OtherStudent.class);
		System.out.println(student1); System.out.println(student2);
		
		System.out.println("ctx.getBean('beanId', className.class) : bean ���");
		// bean ��� �Ϸ�� �� �ش� Ŭ������ destroy() ����
		
		ctx.close();
		System.out.println("ctx.close() : ������ �����̳� ����");
	}

}
