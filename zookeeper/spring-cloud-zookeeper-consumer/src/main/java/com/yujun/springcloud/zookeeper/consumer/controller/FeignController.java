package com.yujun.springcloud.zookeeper.consumer.controller;

import com.yujun.springcloud.zookeeper.consumer.feign.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @version 1.0.0
 * @date 2019/8/12 17:09
 * @description TODO
 **/

@RestController
public class FeignController {

    @Autowired
    private HelloClient helloClient;

    @GetMapping("/feignHello")
    public String feignHello() {
        return helloClient.hello();
    }
}
