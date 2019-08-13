package com.yujun.springcloud.zookeeper_provider.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author admin
 * @version 1.0.0
 * @date 2019/8/13 10:11
 * @description TODO
 **/
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    protected RmiServiceImpl() throws RemoteException {
    }

    @Override
    public String rmiServiceHello() throws RemoteException {
        return "This is rmi service returning 'Hello World'";
    }
}
