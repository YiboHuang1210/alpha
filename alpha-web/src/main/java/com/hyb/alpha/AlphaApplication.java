package com.hyb.alpha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @description:
 * @author: Yibo
 * @create: 2018/8/2
 **/
@SpringBootApplication
@MapperScan("com.hyb.alpha.dao")
public class AlphaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaApplication.class, args);
    }
}
