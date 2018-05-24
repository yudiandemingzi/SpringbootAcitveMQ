package com.jincou.service;

import javax.jms.Destination;

   /**
    * 功能描述：消息生产
    */
public interface ProducerService {

    // 功能描述：指定消息队列，还有消息	
	public void sendMessage(Destination destination, final String message);
	

	// 功能描述：使用默认消息队列， 发送消息
	public void sendMessage( final String message);
	

	 //功能描述：消息发布者
	public void publish(String msg);

}
