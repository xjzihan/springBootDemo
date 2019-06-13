package com.xj.aop.service;

/**
 * SPA服务接口定义
 */
public interface SPAService {

	/**
	 * 全身按摩
	 */
	void fullBodyMassage(String customer);
	
	/**
	 * 精油保健
	 * @param customer
	 */
	void aromaOilMassage(String  customer);
	
	void rest();
}
