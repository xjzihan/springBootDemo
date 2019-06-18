package com.xj.activemq.p2p;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听器
 */
public class JMSListenner implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("JMS Listener 收到的消息：" + ((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
