package com.xj.classloader;

/**
 * 普通单例类
 * 单例模式：
 * 1)重写无参的构造函数为私有的(因为只能有一个对象的实例，构造函数私有化后，无法通过new去创建多个对象的实例)
 * 2)通过public static方法提供获取对象的实例
 * 3)对象的实例始终只有一个
 * 
 * 
 * 第一种：instance 放在count1之上
 * 第二种：instance 放在count2之下
 * 
 * 类加载的步骤：加载-->连接-->初始化
 * 第一步：将编译后的class文件加载到内存
 * 第二步：验证编译后的class文件的正确性
 * 第三步：给类的静态成员变量分配内存空间，并设置其初始值
 * 第四步：给类的静态成员变量分配指定的初始值
 * 
 */
public class Singleton {

	//private static Singleton instance = new Singleton();

	public static int count1;

	public static int count2 = 0;
	
	private static Singleton instance = new Singleton();
	
	private Singleton() {
		count1++;
		count2++;
	}
	
	public static Singleton getInstance() {
		return instance;
	}
}
