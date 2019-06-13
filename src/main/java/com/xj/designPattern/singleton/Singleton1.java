package com.xj.designPattern.singleton;

/**
 * 单例模式：
 * 1）构造方法私有化（类的实例只能有一个，不允许通过new去创建多个）
 * 2）通过public static 方法提供获取对象的实例
 * 3）对象的实例始终只有一个
 *
 * 懒汉模式，非线程安全
 */
public class Singleton1 {

	private Singleton1() {}
	
	private static Singleton1 instance;
	
	public static Singleton1 getInstance() {
		if(instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
