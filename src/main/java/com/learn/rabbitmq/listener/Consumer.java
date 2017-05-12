package com.learn.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class Consumer implements MessageListener {

	public void onMessage(Message message) {
		
		System.out.println("consumer received message:" + new String(message.getBody()));
	}

}
