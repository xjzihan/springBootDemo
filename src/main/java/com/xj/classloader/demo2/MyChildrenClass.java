package com.xj.classloader.demo2;

public class MyChildrenClass extends MyParentClass{

	public MyChildrenClass() {
		System.out.println("Children 无参构造方法 A");
	}
	
	public MyChildrenClass(String name){
		System.out.println("Children 带一个参构造方法 A");
	}
	
	
	{ 
		System.out.println("Children 动态块 B"); 
	}
	 
	
	static {
		System.out.println("Children 静态块 C");
	}
}
