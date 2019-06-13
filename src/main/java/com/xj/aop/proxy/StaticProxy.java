package com.xj.aop.proxy;

import com.xj.aop.service.KTVService;

/**
 * 静态代理类
 */
public class StaticProxy implements KTVService{
	
	private KTVService target;
	
	public StaticProxy(KTVService target) {
		super();
		this.target = target;
	}

	@Override
	public void momoSing(String customer) {
		long startTime = System.currentTimeMillis();
		this.target.momoSing(customer);
		long endTime = System.currentTimeMillis();
		long useTime = endTime - startTime;
		System.out.println("记录：" + this.target.getClass() + ".momoSing 耗时：" + useTime/1000 + "秒");
	}

}
