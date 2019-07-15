package com.xj.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务号的实现类
 */
public class Publisher implements Subject {
	private List<Observer> observers = new ArrayList<Observer>();

	private String msg;

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		int index = observers.indexOf(observer);
		if (index >= 0) {
			observers.remove(index);
		}
	}

	@Override
	public void notifyAllObserver() {
		for (Observer observer : observers) {
			observer.update(msg);
		}
	}
	
	/**
	 * 发送消息
	 */
	public void sendMsg(String msg) {
		this.msg = msg;
		notifyAllObserver();
	}

}
