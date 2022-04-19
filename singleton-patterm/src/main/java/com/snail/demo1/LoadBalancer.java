package com.snail.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 负载均衡器类
 *
 * @author : snail
 * @date : 2022-04-19 21:39
 **/
public class LoadBalancer {

    private List<String> serverList ;

    /**
     * 私有的成员变量，记录当前对象的唯一实例
     */
    private static  LoadBalancer loadBalancer;

    /**
     * 私有构造方法
     */
    private LoadBalancer() {
        serverList = new ArrayList<>();
    }

    /**
     * 获取负载均衡器
     *
     * @return 唯一的负载均衡器
     */
    public static LoadBalancer getLoadBalancer() {
        if (loadBalancer == null){
            loadBalancer = new LoadBalancer();
        }
        return loadBalancer;
    }

    public void addServer(String server){
        serverList.add(server);
    }

    public void removeServer(String server){
        serverList.remove(server);
    }

    public String getServer(){
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return serverList.get(i);
    }
}
