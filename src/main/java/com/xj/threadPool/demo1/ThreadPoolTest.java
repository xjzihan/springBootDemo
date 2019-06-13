package com.xj.threadPool.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Future<String>> threadResultList = new ArrayList<Future<String>>();
		
		ThreadPoolSingleton thread = ThreadPoolSingleton.getInstance();
		
		for(int i = 1; i <= 10;i++) {
			Future<String> f = (Future<String>) thread.execTask(new MyThreadPoolSingletonCallable("线程" + i, i * 1000));
			//Future<String> f = (Future<String>) thread.execTask(new MyThreadPoolSingletonCallable("线程" + i));
			threadResultList.add(f);
		}
		System.out.println("======");
		thread.closeThreadPool();
		System.out.println("########");
		for(Future<String> future : threadResultList) {
			System.out.println(future.get());
			//输出当前线程池的情况
			ThreadPoolExecutor pool = thread.getThreadPoolExecutor();
			System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" + pool.getQueue().size() + "，已执行完任务数目：" + pool.getCompletedTaskCount());
		}
	}
}
