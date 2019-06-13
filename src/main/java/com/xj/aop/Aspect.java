package com.xj.aop;


/**
 * 切面类
 */
public class Aspect {

	/**
	 * 切入点（用于定义切入点表达式）
	 * 
	 */
	private Pointcut pointcut;
	
	/**
	 * 通知
	 */
	private Advice advice;

	public Aspect(Pointcut pointcut, Advice advice) {
		super();
		this.pointcut = pointcut;
		this.advice = advice;
	}

	public Pointcut getPointcut() {
		return pointcut;
	}

	public void setPointcut(Pointcut pointcut) {
		this.pointcut = pointcut;
	}

	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
	
}
