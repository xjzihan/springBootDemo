package com.xj.designPattern.singleton;
/**
 * 单例模式：
 * 1）构造方法私有化（类的实例只能有一个，不允许通过new去创建多个）
 * 2）通过public static 方法提供获取对象的实例
 * 3）对象的实例始终只有一个
 *
 * 懒汉模式+synchronized修饰，使得线程安全
 * synchronized在方法加锁，导致性能会稍差，高并发场景下不太适用
 * 相当于类锁
 */
public class Singleton2 {

	private Singleton2() {}
	
	private static Singleton2 instance;
	
	public static synchronized Singleton2 getInstance() {
		if(instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}
