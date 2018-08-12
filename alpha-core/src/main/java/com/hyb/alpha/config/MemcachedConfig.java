package com.hyb.alpha.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.TextCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/11 13:05
 * @Description: memcache配置
 */
@Configuration
public class MemcachedConfig {

    private static Logger logger = LoggerFactory.getLogger(MemcachedConfig.class);

    @Value("${spring.memcached.timeout}")
    private Long timeOut;
    @Value("${spring.memcached.poolsize}")
    private Integer poolSize;
    @Value("${spring.memcached.server}")
    private String server;
    @Bean
    public XMemcachedClientBuilder clientBuilder() {
        XMemcachedClientBuilder xMemcachedClientBuilder = new XMemcachedClientBuilder(server);
        xMemcachedClientBuilder.setEnableHealSession(true);
        xMemcachedClientBuilder.setConnectionPoolSize(poolSize);
        xMemcachedClientBuilder.setConnectTimeout(timeOut);
        xMemcachedClientBuilder.setCommandFactory(new TextCommandFactory());
        xMemcachedClientBuilder.setSessionLocator(new KetamaMemcachedSessionLocator());
        SerializingTranscoder serializingTranscoder = new SerializingTranscoder();
        serializingTranscoder.setCompressionThreshold(512);
        xMemcachedClientBuilder.setTranscoder(serializingTranscoder);
        return xMemcachedClientBuilder;
    }

    @Bean(destroyMethod = "shutdown")
    public MemcachedClient buildClient(XMemcachedClientBuilder clientBuilder){
        try {
            return clientBuilder.build();
        } catch (IOException e) {
            logger.error("生成cache对象失败！");
        }
        return null;
    }
}
