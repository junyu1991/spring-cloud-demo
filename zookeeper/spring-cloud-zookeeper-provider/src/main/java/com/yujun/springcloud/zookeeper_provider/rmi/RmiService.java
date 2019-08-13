package com.yujun.springcloud.zookeeper_provider.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author admin
 * @version 1.0.0
 * @date 2019/8/13 10:10
 * @description TODO
 **/
public interface RmiService extends Remote {
    public String rmiServiceHello() throws RemoteException;
}
