package com.wvwv.ch08ex04;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

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
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//활성화할 xml 파일의 profiles를 지정
		ctx.getEnvironment().setActiveProfiles(config);
		
		// 둘 중의 active 상태로 설정된 파일을 ctx 변수에 load
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(info);
		
		ctx.close();
	}

}
