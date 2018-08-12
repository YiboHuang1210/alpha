package com.hyb.alpha.component;

import com.hyb.alpha.AlphaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/11 22:32
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlphaApplication.class)
public class RedisTest {

    private final static Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisComponent redisComponent;

    @Test
    public void testSetAndGet() {
        redisComponent.put("redisTestQueryKey", "redisTestContent", 3600);
        logger.info("getFromRedis: {}",redisComponent.get("redisTestQueryKey", String.class));
    }
}
