package com.xj.aop;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟IOC容器
 */
public class IocContainer {

	/**
	 * 简化版的bean定义Map
	 */
	private Map<String, Class<?>> beanDefinitionMap = new HashMap<>();
	
	/**
	 * bean容器
	 */
	private Map<String, Object> beanMap = new HashMap<>();
	
	/**
	 * 简化版切面
	 * （应为一个List，支持多个切面） List<Aspect> aspects = new ArrayList<Aspect>();
	 */
	private Aspect aspect;
	
	/**
	 * 添加bean的定义
	 * @param beanName
	 * @param beanClass
	 */
	public void addBeanDefinition(String beanName, Class<?> beanClass) {
		this.beanDefinitionMap.put(beanName, beanClass);
	}
	
	public Object getBean(String beanName) throws Exception {
		Object bean = beanMap.get(beanName);
		if(bean == null) {
			bean = this.createInstance(beanName);
			bean = this.proxyEnhance(bean);
			this.beanMap.put(beanName, bean);
		}
		return bean;
	}
	
	
	/**
	 * 模拟简化版bean实例的创建
	 * @param beanName
	 */
	private Object createInstance(String beanName) throws Exception {
		return this.beanDefinitionMap.get(beanName).newInstance();
	}
	
	/**
	 * 代理增强处理方法
	 * @param bean
	 * @return
	 */
	private Object proxyEnhance(Object bean) {
		//判断是否需要切面增加，通过动态代理，织入切面，进行增强
		if(this.aspect != null && this.aspect.getPointcut().matchClass(bean.getClass())) {
			return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new AopInvocationHandler(bean, this.aspect));
		}
		return bean;
	}

	public Aspect getAspect() {
		return aspect;
	}

	public void setAspect(Aspect aspect) {
		this.aspect = aspect;
	}
	
}
