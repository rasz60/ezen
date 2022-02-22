package com.wvwv.ch09ex02;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	// aop:around������ ��� �� �� �ִ�.
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatuerStr = joinpoint.getSignature().toShortString();

		System.out.println(signatuerStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatuerStr + " is finished.");
			System.out.println(signatuerStr + " running time : " + (et - st));
		}
	}
	
	//<aop:before> : pointcut �޼��� ���� advice ����
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	
	//<aop:after-returning> : pointcut �޼��� return���� �Ϸ�� �Ŀ� advice ����
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	
	//<aop:after-throwing> : pointcut �޼��� throw exception�ÿ� advice ����
	public void afterThorwingAdvice() {
			System.out.println("afterThorwingAdvice()");
	}
	
	//<aop:after> : pointcut �޼����� ���ܿ��� ������� advice ����
	public void afterAdvice() {
			System.out.println("afterAdvice()");
	}
	
}
