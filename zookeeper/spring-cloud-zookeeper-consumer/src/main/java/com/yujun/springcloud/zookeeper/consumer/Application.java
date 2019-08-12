package com.yujun.springcloud.zookeeper.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author admin
 * @version 1.0.0
 * @date 2019/8/12 17:04
 * @description TODO
 **/
@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
