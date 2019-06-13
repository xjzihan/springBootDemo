package com.xj.aopdemo;

import java.lang.reflect.Method;

import com.xj.aop.Advice;

/**
 * 用户自定义通知类
 */
public class TimeCsAdvice implements Advice{

	@Override
	public Object invoke(Object target, Method method, Object[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		Object ret = method.invoke(target, args);//反射调用目标对象的该方法
		long endTime = System.currentTimeMillis();
		long useTime = endTime - startTime;
		System.out.println("记录：" + target.getClass() + "." + method.getName() + " 耗时：" + useTime/1000 + "秒");
		return ret;
	}

}
