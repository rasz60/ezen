package com.wvwv.ch08_ex04;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//ServletContextListner를 구현한 클래스임을 나타내는 애너테이션 (web.xml에 listener 등록했을 때에는 다시 적을 필요가 없다.)
//@WebListener
public class ContextListenerEx implements ServletContextListener {
	
	public ContextListenerEx () {}

	// contextDestroyed/Initialized() : ServletContextListener abstract methods
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// servlet이 detroy() 됐을 때를 감지하여 실행
		System.out.println("contextDestroyed.");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// servlet이 init() 됐을 때를 감지하여 실행
		System.out.println("contextInitialized.");
	}
	
}
