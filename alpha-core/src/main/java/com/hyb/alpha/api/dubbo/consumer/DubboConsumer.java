package com.hyb.alpha.api.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DubboConsumer {

    private final static Logger logger = LoggerFactory.getLogger(DubboConsumer.class);

    @Reference(version = "1.0.0")
    public DubboOuterProvider dubboOuterProvider;

    public String testConsumer(String s){
        String result = "";
        try {
            result = dubboOuterProvider.getHello(s);
        }catch (Exception e){
            logger.error("DubboConsumer: errMsg{}", e);
        }
        return result;
    }
}

