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
		//Ȱ��ȭ�� xml ������ profiles�� ����
		ctx.getEnvironment().setActiveProfiles(config);
		
		// �� ���� active ���·� ������ ������ ctx ������ load
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(info);
		
		ctx.close();
	}

}
