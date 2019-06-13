package com.xj.classloader;

/**
 * JVM类加载
 */
public class MyLearnClassLoader {

	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		System.out.println(instance.count1);
		System.out.println(instance.count2);
	}

}
