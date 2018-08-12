package com.hyb.alpha.component;

import com.hyb.alpha.config.JmsConfig;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class JMSProducer {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(JmsConfig.QUEUE);
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(JmsConfig.TOPIC);
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, String message) {
        this.jmsTemplate.convertAndSend(destination,message);
    }

}