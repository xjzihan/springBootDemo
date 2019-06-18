package com.xj.activemq.pubsub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.xj.activemq.JMSContants;

/**
 * 消息生产者
 */
public class JMSProducer {
	
	/**
	 * 发送的消息数量
	 */
	private static final int SEND_NUM = 10;

	public static void main(String[] args) {
		ConnectionFactory connectionFactory;//JMS连接工厂
		
		Connection connection = null;//连接
		
		Session session = null;//会话 接受或者发送消息的线程
		
		Destination destination;//消息目的地
		
		MessageProducer messageProducer = null;//消息生产者
		
		//实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSContants.USER_NAME, JMSContants.USER_PASSWORD, JMSContants.BROKE_URL);
		
		
		try {
			//通过连接工厂获取连接对象
			connection = connectionFactory.createConnection();
			//启动连接
			connection.start();
			//创建session(第一个参数：是否增加事务，第二个参数：消息确认的方式)
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);//设置开启事务，消息的确认方式：自动确认
			//创建消息队列
			//destination = session.createQueue(JMSContants.QUEUE_NAME);
			destination = session.createTopic(JMSContants.TOPIC_NAME);//设置为发布订阅的主题模式
			//创建消息生产者
			messageProducer = session.createProducer(destination);
			
			//发送消息
			sendMessage(session, messageProducer);
			
			//提交事务
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			try {
				if(messageProducer != null) {
					messageProducer.close();
				}
				if(session != null) {
					session.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 发送消息方法
	 * @param session
	 * @param messageProducer
	 * @throws JMSException 
	 */
	public static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException {
		for(int i = 0;i < SEND_NUM;i++) {
			String messageStr = "Active MQ 发布的消息" + i;
			TextMessage message = session.createTextMessage(messageStr);
			System.out.println("发送消息：" + messageStr);
			messageProducer.send(message);
		}
	}
	
}
