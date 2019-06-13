package com.xj.aop;

import java.lang.reflect.Method;

/**
 * 定义通知接口
 * 增加功能
 */
public interface Advice {

	Object invoke(Object target, Method method, Object[] args) throws Exception;
}
