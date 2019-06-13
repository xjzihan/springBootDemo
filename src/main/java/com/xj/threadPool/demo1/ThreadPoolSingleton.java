package com.xj.threadPool.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池工具类
 */
public class ThreadPoolSingleton {

	private ThreadPoolSingleton() {}
	
	private static ThreadPoolSingleton instance;
	
	//创建指定线程数的线程池
	//public static ExecutorService executorService = Executors.newFixedThreadPool(3);
	
	/**
	 * Runtime.getRuntime().availableProcessors() == java虚拟机可用的处理器个数
	 * newFixedThreadPool 创建一个固定线程数的线程池，存活时间很长
	 */
	private static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 3);
	
	/**
	 * 使用线程池执行
	 * @param run
	 * @return
	 */
	public Future<?> execTask(Callable<?> run){
		return executorService.submit(run);
	}
	
	/**
	 * 使用线程池执行
	 */
	public void execTask(Runnable runnable) {
		executorService.execute(runnable);
	}
	
	/**
	 * 关闭线程池
	 */
	public void closeThreadPool() {
		executorService.shutdown();
	}
	
	/**
	 * 获取线程池对象
	 * @return
	 */
	public ThreadPoolExecutor getThreadPoolExecutor() {
		return (ThreadPoolExecutor)executorService;
	}
	
	/**
	 * 获取线程实例
	 */
	public static ThreadPoolSingleton getInstance() {
		if(instance == null) {
			synchronized(ThreadPoolSingleton.class) {
				if(instance == null) {
					instance = new ThreadPoolSingleton();
				}
			}
		}
		return instance;
	}
}
