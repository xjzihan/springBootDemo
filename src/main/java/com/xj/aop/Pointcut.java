package com.xj.aop;

import java.lang.reflect.Method;

/**
 * 切入点类
 * 在哪里进行切入增强
 */
public class Pointcut {

	/**
	 * 类名匹配模式（使用正则表达式）
	 */
	private String classPattern;
	
	/**
	 * 方法级的匹配模式（使用正则表达式）
	 */
	private String methodPattern;
	
	public Pointcut(String classPattern, String methodPattern) {
		super();
		this.classPattern = classPattern;
		this.methodPattern = methodPattern;
	}
	
	/**
	 * 简单的类名匹配模式
	 * @param clazz
	 * @return
	 */
	public boolean matchClass(Class<?> clazz) {
		
		return true;
	}
	
	/**
	 * 简单的方法名名匹配模式
	 * @param clazz
	 * @return
	 */
	public boolean matchMethod(Method method) {
		
		return true;
	}

	public String getClassPattern() {
		return classPattern;
	}

	public void setClassPattern(String classPattern) {
		this.classPattern = classPattern;
	}

	public String getMethodPattern() {
		return methodPattern;
	}

	public void setMethodPattern(String methodPattern) {
		this.methodPattern = methodPattern;
	}
}
