package com.wvwv.ch09ex01;

import org.aspectj.lang.ProceedingJoinPoint;

// 횡단 기능을 구현한 클래스
public class LogAop {

	//ProceedingJoinPoint 클래스는 aop:aroud시 proceed() 메서드를 사용하게 하는 클래스
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		// 진행되는 현재 조인트 포인트위치의 메서드 이름(Bean id)을 반환
		// getSignature() : return bean / toShortString() : return bean id
		String signatuerStr = joinpoint.getSignature().toShortString();

		System.out.println(signatuerStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			// 핵심 기능 메서드가 종료될 때까지 보류하고 있다가 완료되면 실행
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatuerStr + " is finished.");
			System.out.println(signatuerStr + " running time : " + (et - st));
		}
	}
}
