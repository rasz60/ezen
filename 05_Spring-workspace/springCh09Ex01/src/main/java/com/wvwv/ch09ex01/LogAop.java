package com.wvwv.ch09ex01;

import org.aspectj.lang.ProceedingJoinPoint;

// Ⱦ�� ����� ������ Ŭ����
public class LogAop {

	//ProceedingJoinPoint Ŭ������ aop:aroud�� proceed() �޼��带 ����ϰ� �ϴ� Ŭ����
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		// ����Ǵ� ���� ����Ʈ ����Ʈ��ġ�� �޼��� �̸�(Bean id)�� ��ȯ
		// getSignature() : return bean / toShortString() : return bean id
		String signatuerStr = joinpoint.getSignature().toShortString();

		System.out.println(signatuerStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			// �ٽ� ��� �޼��尡 ����� ������ �����ϰ� �ִٰ� �Ϸ�Ǹ� ����
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatuerStr + " is finished.");
			System.out.println(signatuerStr + " running time : " + (et - st));
		}
	}
}
