package com.wvwv.ch08ex01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

// �ܺ� ���Ϸ� context ���� ���
public class MainClass {

	public static void main(String[] args) {
		// Environment ������ ���� ��ü�� ��ȯ�ϴ� �޼��� ���� (get/setEnvironment)
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		// spring container�� ������ bean�� �Ӽ� ���� ó���ϴ� ��ü
		MutablePropertySources propertySource = env.getPropertySources();
		try {
			// ���� ���� ������ ������ ResourcePropertySource ��ü�� �����Ͽ� bean �Ӽ� ���� �߰�
			propertySource.addLast(new ResourcePropertySource("classpath:admin.properties"));
			System.out.println( env.getProperty("admin.id") );
			System.out.println( env.getProperty("admin.pw") );
			// ������ �̸��� �Ӽ� ���� �ҷ��´�.
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println(
							"adminID : " + adminConnection.getAdminId() + 
							"\nadminPW : " + adminConnection.getAdminPw()
						   );
		
		ctx.close();
	}

}
