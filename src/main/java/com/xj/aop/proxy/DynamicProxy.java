package com.xj.aop.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理类
 */
public class DynamicProxy {

	/**
	 * 获取动态代理对象
	 * @param <T> 
	 * @param target 委托类对象
	 * @param clazz 接口类对象
	 * @return
	 */
	public static <T> T getProxy(Object target, Class<T> clazz) {
		return (T)Proxy.newProxyInstance(clazz.getClassLoader(), target.getClass().getInterfaces(), new TimeCSinvocationHandler(target));
	}
}
