package com.wvwv.ch08ex05;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		

		while (true) {
			System.out.print("config ? ");
			String str = scanner.next();
			if( str.equals("dev") || str.equals("run")) {
				config = str;
				break;
			} else {
				System.out.println("only dev or run.");
				continue;
			}
		}
		scanner.close();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		
		// ctx에 active 상태가 된 class를 등록
		ctx.register(ApplicationConfigRun.class, ApplicationConfigDev.class);
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(info);
		
		ctx.close();
	}

}
