package com.xj.aop.proxy;

import com.xj.aop.service.KTVService;
import com.xj.aop.service.KtvPrincessB;
import com.xj.aop.service.SPAService;
import com.xj.aop.service.SpaPrincessA;

public class ProxyMain {

	public static void main(String[] args) {
		/**
		 * 静态代理：
		 * 优点：
		 * 1.作为调用者和代理对象的桥梁
		 * 2.无侵入性的增加业务代码，解耦利器
		 * 3.增强点多样化（前入、后入、异常）
		 * 
		 * 缺点：
		 * 1.扩展能力差：
		 * 	1.1横向扩展：代理更多的类
		 *  1.2纵向扩展：增加更多的方法
		 * 2.可维护性差
		 * 横向扩展、纵向扩展时，都需要更改代理类的逻辑
		 */
		KTVService serviceB = new KtvPrincessB();
		KTVService proxy = new StaticProxy(serviceB);
		proxy.momoSing("张三");
		
		System.out.println("=============================动态代理=============================");
		
		/**
		 * 动态代理
		 */
		KTVService ktvProxy = DynamicProxy.getProxy(serviceB, KTVService.class);
		ktvProxy.momoSing("动态代理：张三");
		
		SPAService spaProxy = DynamicProxy.getProxy(new SpaPrincessA(), SPAService.class);
		spaProxy.aromaOilMassage("动态代理：李四");
		
		//ProxyUtils.generateClassFile(SPAService.class, spaProxy.getClass().getName());
	}
}
