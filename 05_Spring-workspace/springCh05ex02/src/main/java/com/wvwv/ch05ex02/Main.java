package com.wvwv.ch05ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		// �������̽��� ��ü �����Ͽ��� xml�� ������ Ŭ���� ��ü�� ������
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		pencil.use();
		ctx.close();
	}

}
