package com.xj.classloader.demo2;

/**
 * 子类、父类，静态代码块、非静态代码块、构造函数的调用顺序
 *1：创建子类第一个实例：父类静态代码块-->子类静态代码块-->父类非静态代码块-->父类构造函数-->子类非静态代码块-->子类构造函数
 *2：创建同一个子类的第二个实例：父类非静态代码块-->父类构造函数-->子类非静态代码块-->子类构造函数
 *3：创建不同子类的第一个实例 ：子类静态代码块-->父类非静态代码块-->父类构造函数-->子类非静态代码块-->子类构造函数
 *
 *总结：
 *1）遵循先父类后子类加载原则
 *2）子类、父类的静态代码块最先加载，遵循先父类后子类的原则
 *3）非静态代码块在构造函数之前加载，并作为一个整体，先加载父类非静态代码块、构造函数后子类静态代码块、构造函数
 */
public class MyParentClass {

	public MyParentClass() {
		System.out.println("Parent 无参构造方法 A");
	}
	
	{ 
		System.out.println("Parent 动态块 B"); 
	}
	
	static {
		System.out.println("Parent static静态块 C");
	}
	
	public static void main(String[] args) {
		MyChildrenClass instance1 = new MyChildrenClass();
		System.out.println("============");
		MyChildrenClass instance2 = new MyChildrenClass();
		System.out.println("============");
		MyChildrenClass2 instance3 = new MyChildrenClass2();
	}
}
