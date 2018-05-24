package com.jincou.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TwoConsumer {

	//名为"two.queue"消息队列的消费者
	@JmsListener(destination="two.queue")
	public void receiveQueue(String text){
		System.out.println("TwoConsumer收到的报文为:"+text);
	}
}
