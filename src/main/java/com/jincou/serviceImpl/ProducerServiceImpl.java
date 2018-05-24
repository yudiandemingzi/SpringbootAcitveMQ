package com.jincou.serviceImpl;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.jincou.service.ProducerService;

/**
 * 功能描述：消息生产者
 */
@Service
public class ProducerServiceImpl implements ProducerService{

	//这个队列就是Springboot主类中bean的对象
	@Autowired
	private Queue queue;
	
	//用来发送消息到broker的对象,可以理解连接数据库的JDBC
	@Autowired
	private JmsMessagingTemplate jmsTemplate; 
	
	
	//发送消息，destination是发送到的队列，message是待发送的消息
	@Override
	public void sendMessage(Destination destination, String message) {		

		jmsTemplate.convertAndSend(destination, message);	
	}

	
	//发送消息，queue是发送到的队列，message是待发送的消息
	@Override
	public void sendMessage(final String message) {
	
		jmsTemplate.convertAndSend(this.queue, message);	
	}
	
	//=======发布订阅相关代码=========
	
		@Autowired
		private Topic topic;
		
		
		 @Override
		public void publish(String msg) {
			this.jmsTemplate.convertAndSend(this.topic, msg);
			
		}
}
