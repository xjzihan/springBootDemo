package com.xj.designPattern.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试单例模式线程是否安全的类
 */
public class SingletonSyncTest {
	
	//private static List<String> objAddrList = new ArrayList<String>();
	private static Set<String> objAddrSet = new HashSet<String>();
	
	
	/**
	 * 第一种单例模式：懒汉模式+线程不安全
	 */
	private static void singleton1() {
		for(int i = 0;i < 100;i++) {
			new Thread(new Runnable() {
				public void run() {
					objAddrSet.add(Singleton1.getInstance().toString());
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
	/**
	 * 第二种单例模式：懒汉模式+synchronized修饰方式，线程安全
	 */
	private static void singleton2() {
		for(int i = 0;i < 100;i++) {
			new Thread(new Runnable() {
				public void run() {
					objAddrSet.add(Singleton2.getInstance().toString());
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
	private static void printObjAddrList() {
		for(String str : objAddrSet) {
			System.out.println(str);
		}
		
	}

	public static void main(String[] args) {
		singleton1();
		//singleton2();
		printObjAddrList();
	}
}
