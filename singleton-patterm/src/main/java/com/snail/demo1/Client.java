package com.snail.demo1;

import cn.hutool.core.lang.Console;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试类
 *
 * @author : snail
 * @date : 2022-04-19 21:50
 **/
public class Client {
    public static void main(String[] args) {
        LoadBalancer balancer1 = LoadBalancer.getLoadBalancer();
        LoadBalancer balancer2 = LoadBalancer.getLoadBalancer();
        LoadBalancer balancer3 = LoadBalancer.getLoadBalancer();
        LoadBalancer balancer4 = LoadBalancer.getLoadBalancer();

        if (balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4){
            Console.log("服务器负责均衡器具有唯一性！");
        }
        balancer1.addServer("server1");
        balancer1.addServer("server2");
        balancer1.addServer("server3");
        balancer1.addServer("server4");

        Map<String,Integer > map = new HashMap<>(4);
        for (int i = 0; i < 10; i++) {
            String server = balancer1.getServer();
            map.put(server,map.get(server) == null ? 1 : map.get(server)+1);
            Console.log("分发请求到服务器：{}",server);
        }

        Console.log(map);
    }
}
