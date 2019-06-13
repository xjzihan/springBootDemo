package com.xj.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AopInvocationHandler implements InvocationHandler{
	/**
	 * 目标类对象
	 */
	private Object target;
	
	/**
	 * 切面
	 */
	private Aspect aspect;
	
	public AopInvocationHandler(Object target, Aspect aspect) {
		super();
		this.target = target;
		this.aspect = aspect;
	}

	/**
	 * @proxy 生成的代理对象
	 * @method 调用代理对象的哪个方法
	 * @args 传入的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//判断方法是否需要增强
		if(this.aspect.getPointcut().matchMethod(method)) {
			return this.aspect.getAdvice().invoke(target, method, args);
		}
		return method.invoke(target, args);
	}

}
