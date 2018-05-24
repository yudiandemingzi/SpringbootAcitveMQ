package com.jincou.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class FirstConsumer {

	//名为"first.queue"消息队列的消费者
	@JmsListener(destination="first.queue")
	public void receiveQueue(String text){
		System.out.println("FirstConsumer收到的报文为:"+text);
	}
}
