package com.hyb.alpha.component;

import com.hyb.alpha.config.JmsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/10 22:44
 * @Description:
 */
@Component
public class JMSConsumer {
    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

    //@JmsListener如果不指定独立的containerFactory的话是只能消费queue消息
    @JmsListener(destination = JmsConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage1(String msg) {
        logger.info("接收到topic1消息：{}",msg);
    }

    @JmsListener(destination=JmsConfig.TOPIC , containerFactory="jmsListenerContainerTopic")
    public void onTopicMessage2(String msg) {
        logger.info("接收到topic2消息：{}",msg);
    }

    @JmsListener(destination=JmsConfig.TOPIC , containerFactory="jmsListenerContainerTopic")
    public void onTopicMessage3(String msg) {
        logger.info("接收到topic3消息：{}",msg);
    }

    @JmsListener(destination = JmsConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage(String msg) {
        logger.info("接收到queue消息：{}",msg);
    }
}
