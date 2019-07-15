package com.xj.designPattern.observer;

/**
 * 观察者基类
 */
public interface Observer {
	/**
	 * 更新
	 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
	 */
	void update(String msg);
}
