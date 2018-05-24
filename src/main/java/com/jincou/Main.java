package com.jincou;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@SpringBootApplication
@EnableJms
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	//新建一个的Queue对象，交给sringboot管理，这个queue的名称叫"first.queue".
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("first.queue");
	}
	
	//新建一个topic队列
	@Bean
	public Topic topic(){
		return new ActiveMQTopic("video.topic");
	}
	
	 @Bean
	    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
	        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
	        bean.setPubSubDomain(true);
	        bean.setConnectionFactory(activeMQConnectionFactory);
	        return bean;
	    }
}



