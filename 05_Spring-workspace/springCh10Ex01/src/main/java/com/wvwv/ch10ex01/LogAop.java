package com.wvwv.ch10ex01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	public LogAop logAop() {
		LogAop logAop = new LogAop();
		return logAop;
	}

	// Pointcut : expression == ("영역") / id="methodName"
	// expression이 메소드 일 때 : 제어자 return-type methodName*(..)*
	@Pointcut("within(com.wvwv.ch10ex01.*)")
	public void pointcutMethod() {}	

	// "weaving time" : pointcut-ref == ("pointCutId") or ("영역 직접 입력") / id="methodName" / advise="in method"
	@Around("within(com.wvwv.ch10ex01.*)")
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
	
	@Before("within(com.wvwv.ch10ex01.*)")
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	
	@AfterReturning("within(com.wvwv.ch10ex01.*)")
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	
	@AfterThrowing("within(com.wvwv.ch10ex01.*)")
	public void afterThorwingAdvice() {
			System.out.println("afterThorwingAdvice()");
	}
	
	@After("within(com.wvwv.ch10ex01.*)")
	public void afterAdvice() {
			System.out.println("afterAdvice()");
	}
}
