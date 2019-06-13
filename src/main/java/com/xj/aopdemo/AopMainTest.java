package com.xj.aopdemo;


import com.xj.aop.Aspect;
import com.xj.aop.IocContainer;
import com.xj.aop.Pointcut;
import com.xj.aop.service.KTVService;
import com.xj.aop.service.KtvPrincessB;
import com.xj.aop.service.SPAService;
import com.xj.aop.service.SpaPrincessA;

public class AopMainTest {
	public static void main(String[] args) throws Exception {
		//1.创建容器
		IocContainer ioc = new IocContainer();
		//2.ioc容器中加入bean对象的定义(定义bean并加入ioc容器中)
		ioc.addBeanDefinition("spa", SpaPrincessA.class);
		ioc.addBeanDefinition("ktv", KtvPrincessB.class);
		
		//3.定义切面（1.切入点规则， 2.增加功能(通知)）
		Pointcut pointcut = new Pointcut("com\\.xj\\.aop\\.servie\\..*", ".*Massage");
		Aspect asp = new Aspect(pointcut, new TimeCsAdvice());
		
		ioc.setAspect(asp);
		
		SPAService spa = (SPAService) ioc.getBean("spa");
		spa.aromaOilMassage("张三");
		
		KTVService ktv = (KTVService) ioc.getBean("ktv");
		ktv.momoSing("李四");
	}
}
