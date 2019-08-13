package com.yujun.springcloud.zookeeper_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author admin
 * @version 1.0.0
 * @date 2019/8/12 15:53
 * @description TODO
 **/
//使用EnableAutoConfiguration注解即可自动化注册当前服务至zookeeper中
//zookeeper中的路径为:/services/${spring.application.name}/random-string
@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
