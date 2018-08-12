package com.hyb.alpha.component;

import com.hyb.alpha.AlphaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/11 22:57
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlphaApplication.class)
public class ActiveMQTest {

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Autowired
    private JMSProducer jmsProducer;

    @Test
    public void send() {
        for(int i=0; i< 10; i++) {
            jmsProducer.sendMessage(queue,"queue,world!" + i);
            jmsProducer.sendMessage(topic, "topic,world!" + i);
        }
    }

}
