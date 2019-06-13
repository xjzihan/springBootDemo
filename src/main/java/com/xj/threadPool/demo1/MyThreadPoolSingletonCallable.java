package com.xj.threadPool.demo1;

import java.util.concurrent.Callable;

/**
 * 定义多线程调用对象，可带返回值
 */
public class MyThreadPoolSingletonCallable implements Callable<String>{
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 休眠时间
	 */
	private long sleepTime;
	
	public MyThreadPoolSingletonCallable(String name) {
		this.name = name;
		this.sleepTime = 0;
	}
	
	public MyThreadPoolSingletonCallable(String name, long sleepTime) {
		this.name = name;
		this.sleepTime = sleepTime;
	}

	public String call() throws Exception {
		Thread.sleep(sleepTime);
		return "当前线程名称：" + name + "，休眠时间：" + sleepTime + "毫秒。";
	}

}
