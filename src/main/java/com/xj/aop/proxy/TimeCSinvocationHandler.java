package com.xj.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 自定义 增加类 
 */
public class TimeCSinvocationHandler implements InvocationHandler{
	private Object target;
	
	public TimeCSinvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object ret = method.invoke(target, args);//反射调用目标对象的该方法
		long endTime = System.currentTimeMillis();
		long useTime = endTime - startTime;
		System.out.println("记录：" + this.target.getClass() + ".momoSing 耗时：" + useTime/1000 + "秒");
		return ret;
	}

}
