package com.wvwv.ch08_ex04;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//ServletContextListner�� ������ Ŭ�������� ��Ÿ���� �ֳ����̼� (web.xml�� listener ������� ������ �ٽ� ���� �ʿ䰡 ����.)
//@WebListener
public class ContextListenerEx implements ServletContextListener {
	
	public ContextListenerEx () {}

	// contextDestroyed/Initialized() : ServletContextListener abstract methods
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// servlet�� detroy() ���� ���� �����Ͽ� ����
		System.out.println("contextDestroyed.");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// servlet�� init() ���� ���� �����Ͽ� ����
		System.out.println("contextInitialized.");
	}
	
}
