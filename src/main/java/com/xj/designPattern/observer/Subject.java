package com.xj.designPattern.observer;

/**
 * 抽象被观察者（主题）
 * 作用：
 * 1.对订阅主题的观察者对象的维护（如：观察者对象的增加、删除）
 */
public interface Subject {

	/**
	 * 注册观察者
	 */
	void registerObserver(Observer observer);
	
	/**
	 * 移除观察者
	 */
	void removeObserver(Observer observer);
	
	/**
	 * 通知到所有的观察者
	 */
	void notifyAllObserver();
}
