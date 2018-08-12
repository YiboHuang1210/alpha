package com.hyb.alpha.api.dubbo.consumer;

/**
 * 消费外部提供的Dubbo接口
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/10 13:00
 **/
public interface DubboOuterProvider {
    String getHello(String name);
}
