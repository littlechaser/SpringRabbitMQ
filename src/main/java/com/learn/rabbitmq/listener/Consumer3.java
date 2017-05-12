package com.learn.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class Consumer3 implements MessageListener{

	public void onMessage(Message message) {
		
		System.out.println("consumer3 received message:" + new String(message.getBody()));
	}

}
