package com.learn.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class Consumer2 implements MessageListener{

	public void onMessage(Message message) {
		
		System.out.println("consumer2 received message:" + new String(message.getBody()));
	}

}
