package com.wvwv.ch05ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		// 인터페이스로 객체 생성하여도 xml에 지정한 클래스 객체가 생성됨
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		pencil.use();
		ctx.close();
	}

}
