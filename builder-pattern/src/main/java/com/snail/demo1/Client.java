package com.snail.demo1;

import com.snail.XMLUtil;

/**
 * 测试类
 *
 * @author : snail
 * @date : 2022-04-03 11:44
 **/
public class Client {
    public static void main(String[] args) {
        // 通过xml配置读取
        // ActorBuilder actorBuilder = new HeroBuilder();
        ActorBuilder actorBuilder = (ActorBuilder) XMLUtil.getBean("angel");
        ActorController actorController = new ActorController();
        Actor actor = actorController.construct(actorBuilder);
        System.out.println(actor);

    }
}
