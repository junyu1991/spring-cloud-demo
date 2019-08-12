package com.yujun.springcloud.zookeeper.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 * @version 1.0.0
 * @date 2019/8/12 17:32
 * @description TODO
 **/
@FeignClient(name="YJ-HelloWorld-Zookeeper")
public interface HelloClient {

    @GetMapping("/hello")
    String hello();
}
