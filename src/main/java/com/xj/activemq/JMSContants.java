package com.xj.activemq;

import org.apache.activemq.ActiveMQConnection;

public class JMSContants {
	/**
	 * 连接用户名
	 */
	public static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;
	
	/**
	 * 连接密码
	 */
	public static final String USER_PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	
	/**
	 * 连接地址
	 */
	public static final String BROKE_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	/**
	 * 队列名称
	 */
	public static final String QUEUE_NAME = "First Queue 1";
	
	/**
	 * 消息主题名称
	 */
	public static final String TOPIC_NAME = "First Topic 1";
}
