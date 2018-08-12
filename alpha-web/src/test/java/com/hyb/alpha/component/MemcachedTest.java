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
 * @Date: 2018/8/11 20:21
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlphaApplication.class)
public class MemcachedTest {

    private final static Logger logger = LoggerFactory.getLogger(MemcachedTest.class);

    @Autowired
    private MemcachedComponent memcachedComponent;

    @Test
    public void testSetAndGet() {
        memcachedComponent.set("memcachedTestKey",3600,"memcachedTestContent");
        logger.info("getFromMemcached: {}",memcachedComponent.get("memcachedTestKey").toString());
    }
}
