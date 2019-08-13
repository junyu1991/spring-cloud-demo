package com.yujun.springcloud.zookeeper_provider.rmi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.zookeeper.serviceregistry.ServiceInstanceRegistration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperRegistration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author admin
 * @version 1.0.0
 * @date 2019/8/13 9:40
 * @description TODO
 **/
@Slf4j
@Configuration
public class HelloRmi {


    //用于向zookeeper中注册服务使用
    @Autowired
    private ZookeeperServiceRegistry serviceRegistry;

    @Value("${rmi.service.port}")
    private int port;
    @Value("${rmi.service.name}")
    private String serviceName;
    @Value("${rmi.service.host}")
    private String host;

    public HelloRmi(){
    }
    @Bean(name = "testRmi")
    public HelloRmi getInstance(){
        String serviceURL = "rmi://" + this.host + ":" + this.port + "/rmiServer";
        try {
            log.info("Starting rmi service:" + this.host +" : " + this.port);
            RmiService rmiService = new RmiServiceImpl();
            LocateRegistry.createRegistry(this.port);
            Naming.bind(serviceURL, rmiService);
            log.info("Start rmi service success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Start registry [" + serviceName + "]");
        ZookeeperRegistration registration = ServiceInstanceRegistration.builder().defaultUriSpec().address(serviceURL)
                .port(this.port).name(this.serviceName).build();
        this.serviceRegistry.register(registration);
        log.info("Registry [" + this.serviceName + "] success");
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }
}
