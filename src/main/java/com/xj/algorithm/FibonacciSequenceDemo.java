package com.xj.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列 递归实现
 * n=1 1
 * n=2 1
 * n=3 2
 * n=4 3
 * n=5 5
 * n=6 8
 */
public class FibonacciSequenceDemo {
	private static Map<Long, Long> resultMap = new HashMap<Long, Long>();
	
	/**
	 * 普通递归方式实现（N>40时就越来越慢了，每计算一个 耗时特别长）
	 * @param num
	 * @return
	 */
	public static Long calc(Long num) {
		if(num == 1 || num == 2) {
			return 1L;
		}else {
			return calc(num - 1) + calc(num - 2);
		}
    }
	
	/**
	 * 递归优化方式
	 * 将每一个计算出来的N对应的结果，使用Map进行存储，计算当前值需要使用到N-1，N-2对应的值时，直接从Map中取值，避免多次重复计算
	 * @param num
	 * @return
	 */
	public static Long calcMap(Long num) {
		if(num == 1 || num == 2) {
			resultMap.put(num, 1L);
		}else {
			Long temp = resultMap.get(num);
			if(temp != null) {
				return temp;
			}else {
				resultMap.put(num, (calcMap(num - 1) + calcMap(num - 2)));
			}
		}
		return resultMap.get(num);
	}
	
	/**
	 * 不使用递归的方式
	 * 类似于冒泡排序，计算N为多少时，就循环计算N次。采用临时变量，将N的最新结果值复制给N-1，原N-1值复制给N-2
	 * @param num
	 * @return
	 */
	public static Long calc3(Long num) {
		if(num == 1 || num == 2) {
			return 1L;
		}else {
			Long num1 = 1L;
			Long num2 = 1L;
			Long num3 = 0L;
			for(int i = 0;i < (num - 2);i++) {
				num3 = num1 + num2;
				num1 = num2;
				num2 = num3;
			}
			return num3;
		}
	}
	
	public static void main(String[] args) {
		//long startTime = System.nanoTime();
		for(int n = 1;n <= 100;n++) {
			//System.out.println("n=" + n + ",value=" + FibonacciSequenceDemo.calc((long)n));
			System.out.println("n=" + n + ",value=" + FibonacciSequenceDemo.calcMap((long)n));
			//System.out.println("n=" + n + ",value=" + FibonacciSequenceDemo.calc3((long)n));
		}
		//System.out.println(FibonacciSequenceDemo.calc3(100L));
		//long endTime = System.nanoTime();
		//System.out.println("耗时：" + (endTime - startTime));
	}
}
