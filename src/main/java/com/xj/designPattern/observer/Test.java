package com.xj.designPattern.observer;

public class Test{

	public static void main(String[] args) {
		Publisher pub = new Publisher();
		
		Subscriber sub1 = new Subscriber("zhangsan");
		Subscriber sub2 = new Subscriber("lisi");
		Subscriber sub3 = new Subscriber("wangwu");
		
		pub.registerObserver(sub1);
		pub.registerObserver(sub2);
		pub.registerObserver(sub3);
		
		System.out.println("==================================");
		pub.sendMsg("123");
		System.out.println("==================================");
		pub.removeObserver(sub1);
		pub.sendMsg("456");
	}

}
