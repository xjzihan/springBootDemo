package com.xj.activemq.pubsub;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听器
 */
public class JMSListenner2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("订阅者2收到的消息：" + ((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
