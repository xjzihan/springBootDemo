package com.xj.aop.proxy;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

/**
 * 获取动态代理类生成的字节码文件内容
 */
public class ProxyUtils {

	/**
	 * 根据类信息动态生成的二进制字节码保存到硬盘中，默认是clazz目录下的params：clazz需要生成动态代理类的类
	 * @param clazz
	 * @param proxyName 为动态生成的代理类的名称
	 */
	public static void generateClassFile(Class clazz,String proxyName) {
		//根据类信息和提供的代理类名称，生成字节码
		byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, new Class[] {clazz});
		
		String paths = clazz.getResource(".").getPath();
		System.out.println(paths);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(paths + proxyName + ".class");
			out.write(classFile);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
