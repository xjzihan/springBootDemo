package com.xj.designPattern.observer;

public class Subscriber implements Observer{
	private String name;
	private String msg;
	
	public Subscriber(String name) {
		this.name = name;
		System.out.println(name + "初始化内容：" + msg);
	}

	@Override
	public void update(String msg) {
		this.msg = msg;
		System.out.println(name + " --> " + msg);
	}

}
