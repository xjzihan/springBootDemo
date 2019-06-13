package com.xj.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeConsumingStatisticsAspect {

	/**
	 * AOP环绕通知
	 */
	@Around("execution(* com.xj.aop.service.*.*(..))")
	public Object methodTimeConsumingStatistics(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object ret = pjp.proceed();
		long endTime = System.currentTimeMillis();
		long useTime = endTime - startTime;
		System.out.println("记录：" + pjp.getTarget() + "," + pjp.getSignature() + ",耗时：" + useTime/1000 + "秒");
		return ret;
	}
}
