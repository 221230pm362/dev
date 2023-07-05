package com.kh.app.aop.timer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Component
@Aspect
@Slf4j
public class TimerAspect {
	
	// 타겟 실행 이전에 동작
//	@Before("target(com.kh.app.member.dao.MemberDao)")
	public void m01() {
		log.debug("@Before ~~~~~~~~~~~~ ");
	}
	
	// 타겟 실행 이후에 동작
//	@After("target(com.kh.app.member.dao.MemberDao)")
	public void m02() {
		log.debug("@After ~~~~~~~~~~~~ ");
	}

	// 타겟 실행 이후, 에러가 없을때 동작
//	@AfterReturning("target(com.kh.app.member.dao.MemberDao)")
	public void m03() {
		log.debug("@AfterReturning ~~~~~~~~~~~~ ");
	}
	
	// 타겟 실행 이후, 에러가 있을때 동작
//	@AfterThrowing("target(com.kh.app.member.dao.MemberDao)")
	public void m04() {
		log.debug("@AfterThrowing ~~~~~~~~~~~~ ");
	}
	
	// 타겟 실행 시점을 지정 가능
	@Around("execution( public * com..dao.*.*(..) )")
//	@Around("target(com.kh.app.member.dao.MemberDao)")
	public Object m05(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		Object o = jp.proceed();	//타겟 메소드 실행
		long end = System.currentTimeMillis();
		long time = end - start;
		String str = jp.getSignature().toString();
		log.debug("{} 메소드 실행시간 : {}ms" , str , time);
		return o;
	}

}













