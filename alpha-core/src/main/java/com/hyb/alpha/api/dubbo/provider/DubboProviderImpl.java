package com.hyb.alpha.api.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class DubboProviderImpl implements DubboProvider {
    @Override
    public String sayHello(String s) {
        return "Hello," + s;
    }
}