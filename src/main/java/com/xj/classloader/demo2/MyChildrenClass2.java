package com.xj.classloader.demo2;

public class MyChildrenClass2 extends MyParentClass{

	public MyChildrenClass2() {
		System.out.println("Children2 无参构造方法 A");
	}
	
	
	{ 
		System.out.println("Children2 动态块 B"); 
	}
	 
	
	static {
		System.out.println("Children2 静态块 C");
	}
}
