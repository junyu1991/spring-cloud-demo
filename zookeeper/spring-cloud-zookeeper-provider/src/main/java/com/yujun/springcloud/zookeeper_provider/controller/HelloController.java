package com.yujun.springcloud.zookeeper_provider.controller;

import com.yujun.springcloud.zookeeper_provider.rmi.HelloRmi;
import com.yujun.springcloud.zookeeper_provider.rmi.client.RmiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.zookeeper.serviceregistry.ServiceInstanceRegistration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperRegistration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @date 2019/8/12 15:58
 * @description TODO
 **/
@Slf4j
@RestController
public class HelloController {

    @Value("${rmi.service.name}")
    private String serviceName;

    @Autowired
    private HelloRmi helloRmi;

    @Autowired
    private RmiClient rmiClient;

    @Autowired
    private ZookeeperServiceRegistry serviceRegistry;

    //用于发现zookeeper中的服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String hello() {
        if(this.helloRmi == null)
            return "NULL RMI";
        return this.helloRmi.getServiceName();
    }

    @RequestMapping("lists")
    public List<ServiceInstance> getInstances() {
        List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
        return list;
    }

    @RequestMapping("/rmi-message")
    public String getMessageFromRmi(){
        return rmiClient.getMessageFromRmiServer();
    }
}
