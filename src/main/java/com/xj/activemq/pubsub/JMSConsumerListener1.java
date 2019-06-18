package com.xj.activemq.pubsub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.xj.activemq.JMSContants;

/**
 * 发布订阅模式-消息订阅者1
 * 主意：需要先启动订阅，然后生产者发布消息，订阅者才能收到
 */
public class JMSConsumerListener1 {

	public static void main(String[] args) {
		ConnectionFactory connectionFactory;// JMS连接工厂

		Connection connection = null;// 连接

		Session session = null;// 会话 接受或者发送消息的线程

		Destination destination;// 消息目的地

		MessageConsumer messageConsumer = null;// 消息的消费者

		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSContants.USER_NAME, JMSContants.USER_PASSWORD,
				JMSContants.BROKE_URL);

		try {
			// 通过连接工厂获取连接对象
			connection = connectionFactory.createConnection();
			// 启动连接
			connection.start();
			// 创建session(第一个参数：是否增加事务，第二个参数：消息确认的方式)
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);// 设置不开启事务（消费者），消息的确认方式：自动确认
			// 创建消息队列
			//destination = session.createQueue(JMSContants.QUEUE_NAME);
			destination = session.createTopic(JMSContants.TOPIC_NAME);////设置为发布订阅的主题模式
			// 创建消息消费者
			messageConsumer = session.createConsumer(destination);

			//注册消息监听
			messageConsumer.setMessageListener(new JMSListenner1());
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
