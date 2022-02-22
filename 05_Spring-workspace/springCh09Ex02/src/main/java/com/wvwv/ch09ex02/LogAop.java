package com.wvwv.ch09ex02;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	// aop:around에서만 사용 할 수 있다.
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
	
	//<aop:before> : pointcut 메서드 전에 advice 실행
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	
	//<aop:after-returning> : pointcut 메서드 return까지 완료된 후에 advice 실행
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	
	//<aop:after-throwing> : pointcut 메서드 throw exception시에 advice 실행
	public void afterThorwingAdvice() {
			System.out.println("afterThorwingAdvice()");
	}
	
	//<aop:after> : pointcut 메서드의 예외여부 상관없이 advice 실행
	public void afterAdvice() {
			System.out.println("afterAdvice()");
	}
	
}
