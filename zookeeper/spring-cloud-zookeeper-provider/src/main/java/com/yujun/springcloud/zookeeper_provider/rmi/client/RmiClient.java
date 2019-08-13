package com.yujun.springcloud.zookeeper_provider.rmi.client;

import com.yujun.springcloud.zookeeper_provider.rmi.RmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @date 2019/8/13 15:36
 * @description TODO
 **/
@Configuration
public class RmiClient {

    //用于发现zookeeper中的服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${rmi.service.name}")
    private String serviceName;

    public RmiClient(){}


    public String getMessageFromRmiServer() {
        List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
        if (list != null && list.size() > 0 ) {
            String url = list.get(0).getHost();
            try {
                RmiService rmiService = (RmiService) Naming.lookup(url);
                return  rmiService.rmiServiceHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
